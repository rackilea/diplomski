public class MyGdxGame extends Game {

    Texture texture;
    SpriteBatch spriteBatch;

    BitmapFont font;

    @Override
    public void create () {

        BitmapFont font=new BitmapFont();  // You initialise local, global is still Null

        texture=new Texture("badlogic.jpg");
        spriteBatch=new SpriteBatch();
    }

    @Override
    public void render() {
        super.render();

        Gdx.gl.glClearColor(1,1,1,1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        spriteBatch.begin();
        spriteBatch.draw(texture,100,100);
        font.draw(spriteBatch,"HELLO WORLD",100,100); // Now here NPE
        spriteBatch.end();
    }
}