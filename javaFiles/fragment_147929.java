@Override
public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    SurfaceView surfaceView = new SurfaceView(this);
    setContentView(surfaceView);

    SurfaceHolder surfaceHolder = surfaceView.getHolder();
    surfaceHolder.addCallback(new SurfaceHolder.Callback() {
        @Override
        public void surfaceDestroyed(SurfaceHolder holder) {
            mCamera.stopPreview();
            mCamera.release();
            mCamera = null;
        }

        @Override
        public void surfaceCreated(SurfaceHolder holder) {
            mCamera = Camera.open(0);
            try {
                mCamera.setPreviewDisplay(holder);
            } catch (IOException exception) {
                mCamera.release();
                mCamera = null;
            }
        }

        @Override
        public void surfaceChanged(SurfaceHolder holder, int format, int width,
                                   int height) {
            mCamera.startPreview();
        }
    });
}