private SpriteBatch batch;
private Viewport viewport;
private Stage stage;
private Texture texture;
private BitmapFont font;

@Override
public void create() {

    batch = new SpriteBatch();
    viewport = new StretchViewport( Gdx.graphics.getWidth(), Gdx.graphics.getHeight() );
    stage = new Stage( viewport, batch );
    texture = new Texture( "badlogic.jpg" );
    font = new BitmapFont();

    Gdx.input.setInputProcessor( stage );

    TextButton.TextButtonStyle textButtonStyle = new TextButton.TextButtonStyle(
            new TextureRegionDrawable( new TextureRegion( texture ) ), null, null, font );
    TextButton textButton = new TextButton( "text", textButtonStyle );
    textButton.setPosition(
            0.5f * Gdx.graphics.getWidth() - 0.5f * textButton.getWidth(),
            0.5f * Gdx.graphics.getHeight() - 0.5f * textButton.getHeight()
            );
    textButton.addListener( new InputListener(){

        @Override
        public boolean touchDown( InputEvent e, float x, float y, int pointer, int button ) {

            Gdx.app.log( "listener A", "touchDown" );

            return true;
        }

        @Override
        public void touchUp( InputEvent e, float x, float y, int pointer, int button ) {

            Gdx.app.log( "listener A", "touchUp" );
        }
    } );
        textButton.addListener( new InputListener(){

        @Override
        public boolean touchDown( InputEvent e, float x, float y, int pointer, int button ) {

            Gdx.app.log( "listener B", "touchDown" );

            return true;
        }

        @Override
        public void touchUp( InputEvent e, float x, float y, int pointer, int button ) {

            Gdx.app.log( "listener B", "touchUp" );
        }
    } );

    stage.addActor( textButton );
}

@Override
public void dispose() {

    batch.dispose();
    stage.dispose();
    texture.dispose();
    font.dispose();
}

@Override
public void resize( int width, int height ) {

    viewport.update( width, height, true );
}

@Override
public void render() {

    Gdx.gl.glClearColor( 0, 0, 0, 1 );
    Gdx.gl.glClear( GL20.GL_COLOR_BUFFER_BIT );

    stage.act( Gdx.graphics.getDeltaTime() );
    stage.draw();
}