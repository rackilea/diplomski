Gdx.gl.glClearColor(0f, 0f, 0f, 1f);
Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

batch.begin();
batch.draw(background, 0, 0, width, height);
batch.end();