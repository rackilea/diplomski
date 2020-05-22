@Override
public void render(float delta) {

    Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);      //clears the buffer 

    CharSequence str = "Main Menu";
    batch = new SpriteBatch();
    font = new BitmapFont();

     batch.begin();
     font.draw(batch, str, 200, 200);
     batch.end();

    if (Gdx.input.justTouched()) // use your own criterion here
        game.setScreen(game.anotherScreen);
}