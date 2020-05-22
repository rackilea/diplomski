byte[] pixels = ScreenUtils.getFrameBufferPixels(0, 0, Gdx.graphics.getBackBufferWidth(), Gdx.graphics.getBackBufferHeight(), true);

    Pixmap pixmap = new Pixmap(Gdx.graphics.getBackBufferWidth(), Gdx.graphics.getBackBufferHeight(), Pixmap.Format.RGBA8888);
    BufferUtils.copy(pixels, 0, pixmap.getPixels(), pixels.length);

    //Your logic here

    pixmap.dispose();