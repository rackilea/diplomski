@Override
public void render(float delta) {
    Settings.clearScreen();
    batch.setProjectionMatrix(cam.combined);
    cam.update();

    batch.setShader(SpriteBatch.createDefaultShader());
    main.buffer.begin();
    batch.begin();
        draw(delta);
    batch.end();
    main.buffer.end();

    //POST PROCESSING
    Texture bufferedTexture = main.buffer.getColorBufferTexture();
    batch.setShader(main.shader);
    batch.begin();
    batch.draw(bufferedTexture, 0, 0, Settings.WIDTH, Settings.HEIGHT, 0, 0, Settings.WIDTH, Settings.HEIGHT, false, true); //need to flip texture
    batch.end();
}