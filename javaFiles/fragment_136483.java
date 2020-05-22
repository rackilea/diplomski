public void render(float delta) {
    Gdx.gl.glClearColor(0, 0, 0, 1);
    Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

    camera.update();

    game.batch.setProjectionMatrix(camera.combined);
    game.batch.begin();

    for (Lane lane : Lanes.lanes) {
        game.batch.draw(game.texture, lane.getPos().x, 0, lane.getRect().width,     lane.getRect().getHeight());
}

game.batch.end();
}