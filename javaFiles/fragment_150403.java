public class GhostSurfaceCameraView extends SurfaceView implements SurfaceHolder.Callback {
        SurfaceHolder mHolder;
        Camera mCamera;

        public GhostSurfaceCameraView(Context context)
        {
            super(context);
            init();
        }
        public GhostSurfaceCameraView(Context context, AttributeSet attrs)
        {
            super(context, attrs);
            init();
        }
        public GhostSurfaceCameraView(Context context, AttributeSet attrs, int defStyle) {
            super(context, attrs, defStyle);
            init();
        }