@Override
public void render () {
    //Clear the screen (1)
    Gdx.gl.glClearColor(1, 1, 1, 1);
    Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

    //Set ProjectionMatrix of SpriteBatch (2)
    batch.setProjectionMatrix(camera.combined);

    batch.begin();
    //Draw image on position 0, 0 with width 25 and height 25 (3)
    batch.draw(img, 0, 0, 25, 25); 
    batch.end();
}