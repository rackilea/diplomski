if (frameBuffer != null && (frameBuffer.getWidth() != width || frameBuffer.getHeight() != height)){
    frameBuffer.dispose();
    frameBuffer = null;
}
if (frameBuffer == null){
    try {
        frameBuffer = new FrameBuffer(Pixmap.Format.RGBA8888, width, height, false);
    } catch (GdxRuntimeException e){ // device doesn't support 8888
        frameBuffer = new FrameBuffer(Pixmap.Format.RGB565, width, height, false);
    }
}