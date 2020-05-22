@SuppressLint("NewApi")
    @Override
    public void onCreateScene(OnCreateSceneCallback pOnCreateSceneCallback) throws IOException {
        // TODO Auto-generated method stub
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.ICE_CREAM_SANDWICH_MR1) {
            mRenderSurfaceView.setPreserveEGLContextOnPause(true);
        }
        initSplashScene();
        pOnCreateSceneCallback.onCreateSceneFinished(this.splashScene);

    }