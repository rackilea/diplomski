private SpriteBatch batch;

public void create () {
    batch = new SpriteBatch();
}

public void render () {
    Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT); // This cryptic line clears the screen.
    batch.begin();
    // Drawing goes here!
    batch.end();
}