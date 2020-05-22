private FrameBuffer frameBuffer;
private final Matrix4 idt = new Matrix4();

public void render() {
    if (frameBuffer == null){
        //Normally this would go in the resize method, but that causes issues on iOS 
        //because resize isn't always called on the GL thread in iOS. So lazy load here.
        try {
            frameBuffer = new FrameBuffer(Format.RGBA8888, Gdx.graphics.getWidth(), Gdx.graphics.getHeight(), false);
        } catch (GdxRuntimeException e){ 
            frameBuffer = new FrameBuffer(Format.RGB565, Gdx.graphics.getWidth(), Gdx.graphics.getHeight(), false);
            //RGBA8888 not supported on all devices. You might instead want to turn off 
            //the water effect if it's not supported, because 565 is kinda ugly.
        }
    }

    frameBuffer.begin();
    Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
    //draw everything that is behind the water layer here
    frameBuffer.end();

    Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
    //Draw the frame buffer texture to the screen:
    spriteBatch.setProjectionMatrix(idt);
    spriteBatch.begin();
    spriteBatch.draw(frameBuffer.getColorBufferTexture(), -1, 1, 2, -2); //IIRC, you need to vertically flip it. If I remembered wrong, then do -1, -1, 2, 2
    spriteBatch.end();

    water.draw(spriteBatch, frameBuffer.getColorBufferTexture());

    //draw stuff that is in front of the water here
}