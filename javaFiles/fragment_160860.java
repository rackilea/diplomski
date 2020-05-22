public class MainRenderer implements GLSurfaceView.Renderer, SurfaceTexture.OnFrameAvailableListener {
    public static final String TAG = "MainRenderer";

    public static final int DEVICE_ORIENTATION_PORTRAIT = 0;
    public static final int DEVICE_ORIENTATION_INVERSE_PORTRAIT = 1;
    public static final int DEVICE_ORIENTATION_LANDSCAPE = 2;
    public static final int DEVICE_ORIENTATION_INVERSE_LANDSCAPE = 3;
    private Camera.CameraInfo cameraInfo;
    public volatile int deviceOrientation = DEVICE_ORIENTATION_PORTRAIT;

    private FSDK.HTracker tracker;

    private int[] textures;

    private Camera camera;
    private SurfaceTexture surfaceTexture;
    private boolean updateSurfaceTexture = false;

    private FSDK.FSDK_Features[] trackingFeatures;
    private MR.MaskFeatures maskCoords;
    private int[] isMaskTexture1Created = new int[]{0};
    private int[] isMaskTexture2Created = new int[]{0};

    private int width;
    private int height;

    private ByteBuffer pixelBuffer;

    private FSDK.HImage cameraImage = new FSDK.HImage();
    private FSDK.FSDK_IMAGEMODE cameraImageMode = new FSDK.FSDK_IMAGEMODE();
    private FSDK.HImage snapshotImage = new FSDK.HImage();
    private FSDK.FSDK_IMAGEMODE snapshotImageMode = new FSDK.FSDK_IMAGEMODE();

    private MainView mainView;
    private MainActivity mainActivity;

    private volatile boolean isResizeCalled = false;
    private volatile boolean isResized = false;

    public long IDs[] = new long[MR.MAX_FACES];
    public long face_count[] = new long[1];

    private long frameCount = 0;
    private long startTime = 0;

    private AtomicBoolean isTakingSnapshot = new AtomicBoolean(false);

    public static final int[][] MASKS = new int[][]{
            {R.raw.lips_pink, R.drawable.lips_pink, R.drawable.lips_pink_normal, MR.SHIFT_TYPE_NO},
            {R.raw.lips_purple, R.drawable.lips_purple, R.drawable.lips_purple_normal, MR.SHIFT_TYPE_NO},
            {R.raw.lips_red, R.drawable.lips_red, R.drawable.lips_red_normal, MR.SHIFT_TYPE_NO},
    };

    private int mask = 0;
    private int maskLoaded = 0;
    private volatile boolean isMaskChanged = false;
    private boolean inPreview = false;

    public void changeMask(int i) {
        mask += i;
        isMaskChanged = true;
    }

    public MainRenderer(MainView view) {
        tracker = Application.tracker;

        mainView = view;
        mainActivity = (MainActivity) mainView.getContext();

        trackingFeatures = new FSDK.FSDK_Features[MR.MAX_FACES];
        for (int i = 0; i < MR.MAX_FACES; ++i) {
            trackingFeatures[i] = new FSDK.FSDK_Features();
            for (int j = 0; j < FSDK.FSDK_FACIAL_FEATURE_COUNT; ++j) {
                trackingFeatures[i].features[j] = new FSDK.TPoint();
            }
        }
        maskCoords = new MR.MaskFeatures();
    }

    public void close() {
        updateSurfaceTexture = false;
        surfaceTexture.release();
        camera.stopPreview();
        camera.release();
        camera = null;
        deleteTex();
    }

    public void startCamera() {
        if (inPreview) {
            camera.stopPreview();
            inPreview = false;
        }
        //NB: if you don't release the current camera before switching, you app will crash
        camera.release();

            //swap the id of the camera to be used
    //Below i have tried to change the camera facing
            if (cameraInfo.facing == Camera.CameraInfo.CAMERA_FACING_BACK) {
                cameraInfo.facing = Camera.CameraInfo.CAMERA_FACING_BACK;
            } else {
                cameraInfo.facing = Camera.CameraInfo.CAMERA_FACING_FRONT;
            }
            camera = Camera.open(cameraInfo.facing);
            //Code snippet for this method from somewhere on android developers, i forget where
            //setCameraDisplayOrientation(mainActivity, cameraInfo.facing, camera);
            try {
                //this step is critical or preview on new camera will no know where to render to
                camera.setPreviewTexture(surfaceTexture);
            } catch (IOException e) {
                e.printStackTrace();
            }
            camera.startPreview();
            inPreview = true;
        }

        public void onSurfaceCreated(GL10 unused, EGLConfig config) { //call opengl functions only inside these functions!
            Log.d(TAG, "surfaceCreated");
            isResizeCalled = false;
            isResized = false;

            initTex();
            loadMask(mask);

            surfaceTexture = new SurfaceTexture(textures[0]);
            surfaceTexture.setOnFrameAvailableListener(this);

            // Find the ID of the camera
            int cameraId = 0;
            boolean frontCameraFound = false;
            cameraInfo = new Camera.CameraInfo();
            for (int i = 0; i < Camera.getNumberOfCameras(); i++) {
                Camera.getCameraInfo(i, cameraInfo);
                if (cameraInfo.facing == Camera.CameraInfo.CAMERA_FACING_BACK) {
                }
                if (cameraInfo.facing == Camera.CameraInfo.CAMERA_FACING_FRONT) {
                    cameraId = i;
                    frontCameraFound = true;
                }
            }

            if (frontCameraFound) {
                camera = Camera.open(cameraId);
            } else {
                camera = Camera.open();
            }

            try {
                camera.setPreviewTexture(surfaceTexture);
            } catch (IOException e) {
                e.printStackTrace();
            }

            GLES11.glClearColor

(0.0f, 0.0f, 0.0f, 1.0f); //background color
    }

    private byte[] readBytes(InputStream inputStream) throws IOException {
        ByteArrayOutputStream byteBuffer = new ByteArrayOutputStream();
        int bufferSize = 16384;
        byte[] buffer = new byte[bufferSize];
        int len;
        while ((len = inputStream.read(buffer)) != -1) {
            byteBuffer.write(buffer, 0, len);
        }
        return byteBuffer.toByteArray();
    }

    // must be called from the thread with OpenGL context!
    @TargetApi(Build.VERSION_CODES.ICE_CREAM_SANDWICH_MR1)
    public void loadMask(int maskNumber) {
        GLES11.glDisable(GLES11Ext.GL_TEXTURE_EXTERNAL_OES);

        Log.d(TAG, "Loading mask...");

        int[] mask = MASKS[maskNumber];

        if (isMaskTexture1Created[0] > 0) {
            GLES11.glDeleteTextures(1, textures, 1);
        }
        if (isMaskTexture2Created[0] > 0) {
            GLES11.glDeleteTextures(1, textures, 2);
        }

        isMaskTexture1Created[0] = 0;
        isMaskTexture2Created[0] = 0;

        InputStream stream = mainView.getResources().openRawResource(mask[0]);
        int res = MR.LoadMaskCoordsFromStream(stream, maskCoords);
        try {
            stream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (res != FSDK.FSDKE_OK) {
            Log.e(TAG, "Error loading mask coords from stream: " + res);
            GLES11.glEnable(GLES11Ext.GL_TEXTURE_EXTERNAL_OES);
            return;
        }

        BitmapFactory.Options bitmapDecodingOptions = new BitmapFactory.Options();
        bitmapDecodingOptions.inScaled = false; // to load original image without scaling

        FSDK.HImage img1 = new FSDK.HImage();
        if (mask[1] == -1) { // if no image
            FSDK.CreateEmptyImage(img1);
        } else {
            stream = mainView.getResources().openRawResource(mask[1]);
            byte[] data = null;
            try {
                data = readBytes(stream);
                stream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            if (data != null) {
                res = FSDK.LoadImageFromPngBufferWithAlpha(img1, data, data.length);
                Log.d(TAG, "Load mask image of size " + data.length + " with result " + res);
                int[] w = new int[]{0};
                int[] h = new int[]{0};
                FSDK.GetImageWidth(img1, w);
                FSDK.GetImageHeight(img1, h);
                Log.d(TAG, "Mask image size: " + w[0] + " x " + h[0]);
            } else {
                Log.w(TAG, "Error loading mask image, using empty image");
                FSDK.CreateEmptyImage(img1);
            }
        }

        FSDK.HImage img2 = new FSDK.HImage();
        if (mask[2] == -1) { // if no normal image
            FSDK.CreateEmptyImage(img2);
        } else {
            stream = mainView.getResources().openRawResource(mask[2]);
            byte[] data = null;
            try {
                data = readBytes(stream);
                stream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            if (data != null) {
                res = FSDK.LoadImageFromPngBufferWithAlpha(img2, data, data.length);
                Log.d(TAG, "Load mask normal image of size " + data.length + " with result " + res);
                int[] w = new int[]{0};
                int[] h = new int[]{0};
                FSDK.GetImageWidth(img2, w);
                FSDK.GetImageHeight(img2, h);
                Log.d(TAG, "Mask normal image size: " + w[0] + " x " + h[0]);
            } else {
                Log.w(TAG, "Error loading mask normal image, using empty image");
                FSDK.CreateEmptyImage(img2);
            }
        }

        res = MR.LoadMask(img1, img2, textures[1], textures[2], isMaskTexture1Created, isMaskTexture2Created);
        FSDK.FreeImage(img1);
        FSDK.FreeImage(img2);

        Log.d(TAG, "Mask loaded with result " + res + " texture1Created:" + isMaskTexture1Created[0] + " texture2Created:" + isMaskTexture2Created[0]);
        Log.d(TAG, "Mask textures: " + textures[1] + " " + textures[2]);

        GLES11.glEnable(GLES11Ext.GL_TEXTURE_EXTERNAL_OES);
    }

    public void onDrawFrame(GL10 unused) { //call opengl functions only inside these functions!
        GLES11.glClear(GLES11.GL_COLOR_BUFFER_BIT);

        if (!isResized) {
            return;
        }

        synchronized (this) {
            if (updateSurfaceTexture) {
                surfaceTexture.updateTexImage();
                updateSurfaceTexture = false;
            }
        }

        if (isMaskChanged) {
            maskLoaded = mask;
            loadMask(mask);
            isMaskChanged = false;
        }

        int rotation = 1;

        // First, drawing without mask to get image buffer
        int res = MR.DrawGLScene(textures[0], 0, trackingFeatures, rotation, MR.SHIFT_TYPE_NO, textures[1], textures[2], maskCoords, 0, 0, width, height);
        if (FSDK.FSDKE_OK != res) {
            Log.e(TAG, "Error in the first MR.DrawGLScene call: " + res);
        }
        GLES11.glReadPixels(0, 0, width, height, GLES11.GL_RGBA, GLES11.GL_UNSIGNED_BYTE, pixelBuffer);

        face_count[0] = 0;

        processCameraImage();

        // Second, drawing with mask atop of image
        res = MR.DrawGLScene(textures[0], (int) face_count[0], trackingFeatures, rotation, MASKS[maskLoaded][3], textures[1], textures[2], maskCoords, isMaskTexture1Created[0], isMaskTexture2Created[0], width, height);
        if (FSDK.FSDKE_OK != res) {
            Log.e(TAG, "Error in the second MR.DrawGLScene call: " + res);
        }

        // Save snapshot if needed
        if (isTakingSnapshot.compareAndSet(true, false)) {
            GLES11.glReadPixels(0, 0, width, height, GLES11.GL_RGBA, GLES11.GL_UNSIGNED_BYTE, pixelBuffer);
            snapshotImageMode.mode = FSDK.FSDK_IMAGEMODE.FSDK_IMAGE_COLOR_32BIT;
            res = FSDK.LoadImageFromBuffer(snapshotImage, pixelBuffer.array(), width, height, width * 4, snapshotImageMode);
            if (FSDK.FSDKE_OK != res) {
                Log.e(TAG, "Error loading snapshot image to FaceSDK: " + res);
            } else {
                FSDK.MirrorImage(snapshotImage, false);

                String galleryPath = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES).getAbsolutePath();
                final String filename = galleryPath + "/MirrorRealityDemo" + System.currentTimeMillis() + ".png";
                res = FSDK.SaveImageToFile(snapshotImage, filename);
                Log.d(TAG, "saving snapshot to " + filename);

                FSDK.FreeImage(snapshotImage);

                if (FSDK.FSDKE_OK == res) {
                    mainActivity.runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            Intent mediaScanIntent = new Intent(Intent.ACTION_MEDIA_SCANNER_SCAN_FILE);
                            File f = new File(filename);
                            Uri contentUri = Uri.fromFile(f);
                            mediaScanIntent.setData(contentUri);
                            mainActivity.sendBroadcast(mediaScanIntent);

                            Toast.makeText(mainActivity, "Saved successfully", Toast.LENGTH_SHORT).show();
                        }
                    });
                }
            }
        }

        // Show fps
        ++frameCount;
        long timeCurrent = System.currentTimeMillis();
        if (startTime == 0) startTime = timeCurrent;
        long diff = timeCurrent - startTime;
        if (diff >= 3000) {
            final float fps = frameCount / (diff / 1000.0f);
            frameCount = 0;
            startTime = 0;

            final TextView fpsTextView = mainActivity.fpsTextView();
            mainActivity.fpsTextView().post(new Runnable() {
                @Override
                public void run() {
                    if (!mainActivity.isFinishing()) {
                        fpsTextView.setText(fps + " FPS");
                    }
                }
            });
        }
    }

    private void processCameraImage() {
        //clear previous features
        for (int i = 0; i < MR.MAX_FACES; ++i) {
            for (int j = 0; j < FSDK.FSDK_FACIAL_FEATURE_COUNT; ++j) {
                trackingFeatures[i].features[j].x = 0;
                trackingFeatures[i].features[j].y = 0;
            }
        }

        cameraImageMode.mode = FSDK.FSDK_IMAGEMODE.FSDK_IMAGE_COLOR_32BIT;
        int res = FSDK.LoadImageFromBuffer(cameraImage, pixelBuffer.array(), width, height, width * 4, cameraImageMode);
        if (FSDK.FSDKE_OK != res) {
            Log.e(TAG, "Error loading camera image to FaceSDK: " + res);
            return;
        }

        FSDK.MirrorImage(cameraImage, false);
        int[] widthByReference = new int[1];
        int[] heightByReference = new int[1];
        FSDK.GetImageWidth(cameraImage, widthByReference);
        FSDK.GetImageHeight(cameraImage, heightByReference);
        int width = widthByReference[0];
        int height = heightByReference[0];

        int rotation = 0;
        if (deviceOrientation == DEVICE_ORIENTATION_INVERSE_PORTRAIT) {
            rotation = 2;
        } else if (deviceOrientation == DEVICE_ORIENTATION_LANDSCAPE) {
            rotation = 3;
        } else if (deviceOrientation == DEVICE_ORIENTATION_INVERSE_LANDSCAPE) {
            rotation = 1;
        }

        if (rotation > 0) {
            FSDK.HImage rotated = new FSDK.HImage();
            FSDK.CreateEmptyImage(rotated);
            FSDK.RotateImage90(cameraImage, rotation, rotated);
            FSDK.FeedFrame(tracker, 0, rotated, face_count, IDs);
            FSDK.FreeImage(rotated);
        } else {
            FSDK.FeedFrame(tracker, 0, cameraImage, face_count, IDs);
        }

        for (int i = 0; i < (int) face_count[0]; ++i) {
            FSDK.GetTrackerFacialFeatures(tracker, 0, IDs[i], trackingFeatures[i]);
            if (rotation > 0) {
                if (rotation == 1) {
                    for (int j = 0; j < FSDK.FSDK_FACIAL_FEATURE_COUNT; ++j) {
                        int x = trackingFeatures[i].features[j].x;
                        trackingFeatures[i].features[j].x = trackingFeatures[i].features[j].y;
                        trackingFeatures[i].features[j].y = height - 1 - x;
                    }
                } else if (rotation == 2) {
                    for (int j = 0; j < FSDK.FSDK_FACIAL_FEATURE_COUNT; ++j) {
                        trackingFeatures[i].features[j].x = width - 1 - trackingFeatures[i].features[j].x;
                        trackingFeatures[i].features[j].y = height - 1 - trackingFeatures[i].features[j].y;
                    }
                } else {
                    for (int j = 0; j < FSDK.FSDK_FACIAL_FEATURE_COUNT; ++j) {
                        int x = trackingFeatures[i].features[j].x;
                        trackingFeatures[i].features[j].x = width - 1 - trackingFeatures[i].features[j].y;
                        trackingFeatures[i].features[j].y = x;
                    }
                }
            }
        }

        FSDK.FreeImage(cameraImage);
    }

    public void onSurfaceChanged(GL10 unused, int width, int height) { //call opengl functions only inside these functions!
        Log.d(TAG, "surfaceChanged");
        if (!isResizeCalled) {
            isResizeCalled = true;
            mainView.resizeForPerformance(width, height);
            return;
        }

        GLES11.glViewport(0, 0, width, height);
        Camera.Parameters param = camera.getParameters();
        List<Camera.Size> psize = param.getSupportedPreviewSizes();
        if (psize.size() > 0) {
            int i = 0;
            int optDistance = Integer.MAX_VALUE;
            Log.d(TAG, "Choosing preview resolution closer to " + width + " x " + height);

            double neededScale = height / (double) width;
            for (int j = 0; j < psize.size(); ++j) {
                double scale = psize.get(j).width / (double) psize.get(j).height;
                int distance = (int) (10000 * Math.abs(scale - neededScale));

                Log.d(TAG, "Choosing preview resolution, probing " + psize.get(j).width + " x " + psize.get(j).height + " distance: " + distance);
                if (distance < optDistance) {
                    i = j;
                    optDistance = distance;
                } else if (distance == optDistance) {
                    // try to avoid too low resolution
                    if ((psize.get(i).width < 300 || psize.get(i).height < 300)
                            && psize.get(j).width > psize.get(i).width && psize.get(j).height > psize.get(i).height) {
                        i = j;
                    }
                }
            }

            Log.d(TAG, "Using optimal preview size: " + psize.get(i).width + " x " + psize.get(i).height);
            param.setPreviewSize(psize.get(i).width, psize.get(i).height);

            // adjusting viewport to camera aspect ratio
            int viewportHeight = (int) (width * (psize.get(i).width * 1.0f / psize.get(i).height));

            GLES11.glViewport(0, 0, width, viewportHeight);

            this.width = width;
            this.height = viewportHeight;
            pixelBuffer = ByteBuffer.allocateDirect(this.width * this.height * 4).order(ByteOrder.nativeOrder());
        }

        param.set("orientation", "landscape");
        camera.setParameters(param);
        camera.startPreview();
        inPreview = true;
        isResized = true;
    }

    @TargetApi(Build.VERSION_CODES.ICE_CREAM_SANDWICH_MR1)
    private void initTex() {
        textures = new int[3];
        GLES11.glEnable(GLES11Ext.GL_TEXTURE_EXTERNAL_OES);
        GLES11.glEnable(GL10.GL_TEXTURE_2D);
        GLES11.glGenTextures(3, textures, 0);
        GLES11.glBindTexture(GLES11Ext.GL_TEXTURE_EXTERNAL_OES, textures[0]);
        GLES11.glTexParameteri(GLES11Ext.GL_TEXTURE_EXTERNAL_OES, GLES11.GL_TEXTURE_WRAP_S, GLES11.GL_CLAMP_TO_EDGE);
        GLES11.glTexParameteri(GLES11Ext.GL_TEXTURE_EXTERNAL_OES, GLES11.GL_TEXTURE_WRAP_T, GLES11.GL_CLAMP_TO_EDGE);
        GLES11.glTexParameteri(GLES11Ext.GL_TEXTURE_EXTERNAL_OES, GLES11.GL_TEXTURE_MIN_FILTER, GLES11.GL_NEAREST);
        GLES11.glTexParameteri(GLES11Ext.GL_TEXTURE_EXTERNAL_OES, GLES11.GL_TEXTURE_MAG_FILTER, GLES11.GL_NEAREST);
    }

    private void deleteTex() {
        GLES11.glDeleteTextures(3, textures, 0);
    }

    public synchronized void onFrameAvailable(SurfaceTexture st) {
        updateSurfaceTexture = true;
        mainView.requestRender();
    }

    public synchronized void snapshot() {
        isTakingSnapshot.set(true);
    }
}