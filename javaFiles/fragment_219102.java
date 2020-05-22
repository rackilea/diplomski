private void initView() {
    mTextureView = (TextureView) findViewById(R.id.textureView);
    // SurfaceTexture is available only after the TextureView
    // is attached to a window and onAttachedToWindow() has been invoked.
    // We need to use SurfaceTextureListener to be notified when the SurfaceTexture
    // becomes available.
    mTextureView.setSurfaceTextureListener(this);

    FrameLayout rootView = (FrameLayout) findViewById(R.id.rootView);
    rootView.setOnTouchListener(new View.OnTouchListener() {
        @Override
        public boolean onTouch(View view, MotionEvent motionEvent) {
            switch (motionEvent.getAction()) {
                case MotionEvent.ACTION_UP:
                    updateTextureViewSize((int) motionEvent.getX(), (int) motionEvent.getY());
                    break;
            }
            return true;
        }
    });
}

private void updateTextureViewSize(int viewWidth, int viewHeight) {
    mTextureView.setLayoutParams(new FrameLayout.LayoutParams(viewWidth, viewHeight));
}