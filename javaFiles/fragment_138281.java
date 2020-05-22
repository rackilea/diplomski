public class MenuScreen extends InputAdapter implements Screen  {

    SpriteBatch batch;
    Texture background,play,credits;

    Sprite backgoundSprite,playSprite,creditsSprite;
    private ExtendViewport extendViewport;

    OrthographicCamera cam;
    private float w=480;
    private float h=800;
    private Vector3 vector3;

    MyGdxGame game;
    Music music;

    public MenuScreen(MyGdxGame game){
        this.game=game;
    }

    @Override
    public void show() {

        batch = new SpriteBatch();
        cam = new OrthographicCamera();
        extendViewport=new ExtendViewport(w,h,cam);

        vector3=new Vector3();

        background = new Texture("Main_Screen.png");
        play=new Texture("play.png");
        credits=new Texture("credits.png");

        backgoundSprite=new Sprite(background);
        backgoundSprite.setSize(w,h);       // If resources are not in context of your viewport
        backgoundSprite.setPosition(0,0);  //Default Position

        playSprite=new Sprite(play);
        playSprite.setSize(100,100);
        playSprite.setPosition(w/2-playSprite.getWidth()/2,h/2+100);

        creditsSprite=new Sprite(credits);
        creditsSprite.setSize(100,100);
        creditsSprite.setPosition(w/2-creditsSprite.getWidth()/2,h/2-100);

        Gdx.input.setInputProcessor(this);

        music = Gdx.audio.newMusic(Gdx.files.internal("bgmusic.wav"));
        music.play();
        music.setLooping(true);   
    }

    @Override
    public void render(float delta) {

        Gdx.gl.glClearColor(1, 1, 1, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        batch.setProjectionMatrix(cam.combined);
        batch.begin();
        backgoundSprite.draw(batch);
        playSprite.draw(batch);
        creditsSprite.draw(batch);
        batch.end();
    }

    @Override
    public void resize(int width, int height) {

        extendViewport.update(width,height);
        cam.position.x = w /2;
        cam.position.y = h/2;
        cam.update();
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        vector3.set(screenX,screenY,0);
        Vector3 position=cam.unproject(vector3);
            if(playSprite.getBoundingRectangle().contains(position.x,position.y)) {
            game.setScreen(game.playScreen);
        }
        if(creditsSprite.getBoundingRectangle().contains(position.x,position.y)){
            game.setScreen(game.creditsScreen);
        }

        return super.touchDown(screenX, screenY, pointer, button);
    }

    @Override
    public void pause() { }

    @Override
    public void resume() { }

    @Override
    public void hide() { }

    @Override
    public void dispose() {
        batch.dispose();
        background.dispose();
        play.dispose();
        credits.dispose();
    }
}