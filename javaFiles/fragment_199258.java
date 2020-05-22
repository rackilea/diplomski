public class MainMenuScreen implements Screen,InputProcessor {

final MainClass game;
String playButton = "PLAY";
private int screenWidth;
private int screenHeight;

Rectangle recPlayButton;
GlyphLayout layout;

public MainMenuScreen(final MainClass gam){
    game=gam;
    Gdx.input.setInputProcessor(this);

    screenHeight = Gdx.graphics.getHeight();
    screenWidth = Gdx.graphics.getWidth();\

    layout = new GlyphLayout();
    recPlayButton = new Rectangle();

    layout.setText(game.font, playButton);
    recPlayButton.set(screenWidth / 3, screenHeight / 2, layout.width, layout.height);
}

@Override
public void render(float delta) {

    Gdx.gl.glClearColor(0, 0.2f, 0, 10);
    Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

    game.batch.begin();
    game.font.draw(game.batch,playButton,screenWidth/3,screenHeight/2);
    game.batch.end();
}

@Override
public boolean touchDown(int screenX, int screenY, int pointer, int button) {
    Vector3 touchPos = new Vector3(screenX, screenY, 0);

    if (recPlayButton.contains(touchPos.x, touchPos.y)) {
        Gdx.app.log("Test", "Button was clicked");
        return true;
    } 

    return false;        
}