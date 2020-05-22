@Override public void render() {
    Gdx.gl.glClearColor(1, 1, 1, 1);
    Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
    controller.update(Gdx.graphics.getDeltaTime());
    batch.setProjectionMatrix(camera.combined);
    batch.begin();
    sprite.draw(batch);
    batch.end();
}