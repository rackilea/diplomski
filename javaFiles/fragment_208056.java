batch.setProjectionMatrix(camera.combined);
batch.draw(
           frameTexture,
           0,
           viewport.getScreenHeight() - FRAME_TEXTURE_HEIGHT,
           FRAME_TEXTURE_WIDTH,
           FRAME_TEXTURE_HEIGHT);