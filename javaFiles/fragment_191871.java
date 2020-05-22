@Override
protected void onResume() {
    super.onResume();
    camera = Camera.open(CAMERA_ID);
    holder = surfaceView.getHolder();
    holder.setType(SurfaceHolder.SURFACE_TYPE_PUSH_BUFFERS);
    holderCallback = new HolderCallback();
    holder.addCallback(holderCallback);
}