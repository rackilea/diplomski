public class HardwareCamera implements CameraAccess.ICamera,
        Camera.PreviewCallback {

    // see http://developer.android.com/guide/topics/media/camera.html for more
    // details

    private static final boolean USE_THREAD = true;

    private final static String TAG = "HardwareCamera";
    private final Context context;
    private final int cameraIndex; // example: CameraInfo.CAMERA_FACING_FRONT or
                                    // -1 for
    // IP_CAM
    private final CameraAccess user;
    private Camera mCamera;
    private int mFrameWidth;
    private int mFrameHeight;
    private CameraAccessFrame mCameraFrame;
    private CameraHandlerThread mThread = null;
    private SurfaceTexture texture = new SurfaceTexture(0);

    // needed to avoid OpenCV error:
    // "queueBuffer: BufferQueue has been abandoned!"
    private byte[] mBuffer;

    public HardwareCamera(Context context, CameraAccess user, int cameraIndex) {
        this.context = context;
        this.cameraIndex = cameraIndex;
        this.user = user;
    }

    // private boolean checkCameraHardware() {
    // if (context.getPackageManager().hasSystemFeature(
    // PackageManager.FEATURE_CAMERA)) {
    // // this device has a camera
    // return true;
    // } else {
    // // no camera on this device
    // return false;
    // }
    // }

    public static Camera getCameraInstance(int facing) {

        Camera c = null;
        Camera.CameraInfo cameraInfo = new Camera.CameraInfo();
        int cameraCount = Camera.getNumberOfCameras();
        int index = -1;

        for (int camIdx = 0; camIdx < cameraCount; camIdx++) {
            Camera.getCameraInfo(camIdx, cameraInfo);
            if (cameraInfo.facing == facing) {
                try {
                    c = Camera.open(camIdx);
                    index = camIdx;
                    break;
                } catch (RuntimeException e) {
                    Log.e(TAG,
                            String.format(
                                    "Camera is not available (in use or does not exist). Facing: %s Index: %s Error: %s",
                                    facing, camIdx, e.getMessage()));

                    continue;
                }
            }
        }

        if (c != null)
            Log.d(TAG, String.format("Camera opened. Facing: %s Index: %s",
                    facing, index));
        else
            Log.e(TAG, "Could not find any camera matching facing: " + facing);

        // returns null if camera is unavailable
        return c;
    }

    private synchronized void connectLocalCamera() {
        if (!user.isOpenCVLoaded())
            return;

        if (USE_THREAD) {
            if (mThread == null) {
                mThread = new CameraHandlerThread(this);
            }

            synchronized (mThread) {
                mThread.openCamera();
            }
        } else {
            oldConnectCamera();
        }

        user.onCameraInitialized(mFrameWidth, mFrameHeight);
    }

    private/* synchronized */void oldConnectCamera() {
        // synchronized (this) {
        if (true) {// checkCameraHardware()) {
            mCamera = getCameraInstance(cameraIndex);
            if (mCamera == null)
                return;

            Parameters params = mCamera.getParameters();
            List<Camera.Size> sizes = params.getSupportedPreviewSizes();

            // Camera.Size previewSize = sizes.get(0);
            Collections.sort(sizes, new PreviewSizeComparer());
            Camera.Size previewSize = null;
            for (Camera.Size s : sizes) {
                if (s == null)
                    break;

                previewSize = s;
            }

            // List<Integer> formats = params.getSupportedPictureFormats();
            // params.setPreviewFormat(ImageFormat.NV21);

            params.setPreviewSize(previewSize.width, previewSize.height);
            mCamera.setParameters(params);

            params = mCamera.getParameters();

            mFrameWidth = params.getPreviewSize().width;
            mFrameHeight = params.getPreviewSize().height;

            int size = mFrameWidth * mFrameHeight;
            size = size
                    * ImageFormat.getBitsPerPixel(params.getPreviewFormat())
                    / 8;

            this.mBuffer = new byte[size];
            Log.d(TAG, "Created callback buffer of size (bytes): " + size);

            Mat mFrame = new Mat(mFrameHeight + (mFrameHeight / 2),
                    mFrameWidth, CvType.CV_8UC1);
            mCameraFrame = new CameraAccessFrame(mFrame, mFrameWidth,
                    mFrameHeight);

            if (this.texture != null)
                this.texture.release();

            this.texture = new SurfaceTexture(0);

            try {
                mCamera.setPreviewTexture(texture);
                mCamera.addCallbackBuffer(mBuffer);
                mCamera.setPreviewCallbackWithBuffer(this);
                mCamera.startPreview();

                Log.d(TAG,
                        String.format(
                                "Camera preview started with %sx%s. Rendering to SurfaceTexture dummy while receiving preview frames.",
                                mFrameWidth, mFrameHeight));
            } catch (Exception e) {
                Log.d(TAG, "Error starting camera preview: " + e.getMessage());
            }
        }
        // }
    }

    @Override
    public synchronized void onPreviewFrame(byte[] frame, Camera arg1) {
        mCameraFrame.put(frame);

        if (user.isAutomaticReceive() || user.waitForReceive(500))
            user.onPreviewFrame(mCameraFrame);

        if (mCamera != null)
            mCamera.addCallbackBuffer(mBuffer);
    }

    private class CameraAccessFrame implements CameraFrame {
        private Mat mYuvFrameData;
        private Mat mRgba;
        private int mWidth;
        private int mHeight;
        private Bitmap mCachedBitmap;
        private boolean mRgbaConverted;
        private boolean mBitmapConverted;

        @Override
        public Mat gray() {
            return mYuvFrameData.submat(0, mHeight, 0, mWidth);
        }

        @Override
        public Mat rgba() {
            if (!mRgbaConverted) {
                Imgproc.cvtColor(mYuvFrameData, mRgba,
                        Imgproc.COLOR_YUV2BGR_NV12, 4);
                mRgbaConverted = true;
            }
            return mRgba;
        }

        // @Override
        // public Mat yuv() {
        // return mYuvFrameData;
        // }

        @Override
        public synchronized Bitmap toBitmap() {
            if (mBitmapConverted)
                return mCachedBitmap;

            Mat rgba = this.rgba();
            Utils.matToBitmap(rgba, mCachedBitmap);

            mBitmapConverted = true;
            return mCachedBitmap;
        }

        public CameraAccessFrame(Mat Yuv420sp, int width, int height) {
            super();
            mWidth = width;
            mHeight = height;
            mYuvFrameData = Yuv420sp;
            mRgba = new Mat();

            this.mCachedBitmap = Bitmap.createBitmap(width, height,
                    Bitmap.Config.ARGB_8888);
        }

        public synchronized void put(byte[] frame) {
            mYuvFrameData.put(0, 0, frame);
            invalidate();
        }

        public void release() {
            mRgba.release();
            mCachedBitmap.recycle();
        }

        public void invalidate() {
            mRgbaConverted = false;
            mBitmapConverted = false;
        }
    };

    private class PreviewSizeComparer implements Comparator<Camera.Size> {
        @Override
        public int compare(Size arg0, Size arg1) {
            if (arg0 != null && arg1 == null)
                return -1;
            if (arg0 == null && arg1 != null)
                return 1;

            if (arg0.width < arg1.width)
                return -1;
            else if (arg0.width > arg1.width)
                return 1;
            else
                return 0;
        }
    }

    private static class CameraHandlerThread extends HandlerThread {
        Handler mHandler;
        HardwareCamera owner;

        CameraHandlerThread(HardwareCamera owner) {
            super("CameraHandlerThread");

            this.owner = owner;

            start();
            mHandler = new Handler(getLooper());
        }

        synchronized void notifyCameraOpened() {
            notify();
        }

        void openCamera() {
            mHandler.post(new Runnable() {
                @Override
                public void run() {
                    owner.oldConnectCamera();
                    notifyCameraOpened();
                }
            });

            try {
                wait();
            } catch (InterruptedException e) {
                Log.w(TAG, "wait was interrupted");
            }
        }
    }

    @Override
    public boolean supportsRegionOfInterest() {
        return false;
    }

    @Override
    public void connect() {
        connectLocalCamera();
    }

    @Override
    public void release() {
        synchronized (this) {

            if (USE_THREAD) {
                if (mThread != null) {
                    mThread.interrupt();
                    mThread = null;
                }
            }

            if (mCamera != null) {
                mCamera.stopPreview();
                mCamera.setPreviewCallback(null);
                try {
                    mCamera.setPreviewTexture(null);
                } catch (IOException e) {
                    Log.e(TAG, "Could not release preview-texture from camera.");
                }

                mCamera.release();

                Log.d(TAG, "Preview stopped and camera released");
            }
            mCamera = null;

            if (mCameraFrame != null) {
                mCameraFrame.release();
            }

            if (texture != null)
                texture.release();
        }
    }

    @Override
    public boolean isConnected() {
        return mCamera != null;
    }
}