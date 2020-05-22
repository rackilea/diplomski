if (DeviceVersion.atLeast(API_14)) {
    TextureView view = (TextureView) root.findViewById(R.id.texture_view);
    // ... do something with TextureView ...
}
else {
    SurfaceView view = (SurfaceView) root.findViewById(R.id.texture_view);
    // .... do something with SurfaceView
}