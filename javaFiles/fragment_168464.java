@Override
public void render(float delta) {
    translateCamera();

    Gdx.gl.glClearColor(0, 0, 0, 1);
    Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);

    camera.update();

    renderer.setView(camera);

    renderer.render(bgLayers);

    //here's the line that was missing.
    batch.setProjectionMatrix(camera.combined);
    batch.begin();

    //be sure to call this instead of specifying position yourself!
    splayerSprite.draw(batch);
    batch.end();
    renderer.render(fgLayers);

}