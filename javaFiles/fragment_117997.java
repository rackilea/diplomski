public void render (float runTime) {
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        batch.begin();
        batch.draw(badLogic, 0, 0);
        batch.end();
    }