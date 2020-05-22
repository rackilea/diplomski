public MainMenu(RTSGame game){
    this.game = game;

    stage = new Stage( new FitViewport( 1920, 1080 ));

    Table rootTable = new Table();
    rootTable.setFillParent(true);
    rootTable.setDebug(true, true);

    Table menuTable = new Table();
    rootTable.add(menuTable).expand().center().right();

    Skin skin = new Skin(Gdx.files.internal("data/uiskin.json"));

    TextButton singlePlayer = new TextButton("Single Player",skin);
    TextButton multiPlayer = new TextButton("Multi Player", skin);
    TextButton options = new TextButton("Options", skin);
    TextButton exit = new TextButton("Exit", skin);

    int y = 1080;
    int unit = y / 8;

    float scale = unit / singlePlayer.getHeight();

    float width = singlePlayer.getWidth() * scale;

    Label.LabelStyle style = new Label.LabelStyle();

    style.font = game.fontMenu;

    singlePlayer.getLabel().setStyle(style);
    multiPlayer.getLabel().setStyle(style);
    options.getLabel().setStyle(style);
    exit.getLabel().setStyle(style);

    float fontScale = ( singlePlayer.getLabel().getPrefWidth() + 20 ) / width;

    Gdx.app.log( "label-height", singlePlayer.getLabel().getHeight() + "" );
    Gdx.app.log( "label-prefheight", singlePlayer.getLabel().getPrefHeight() + "" );
    Gdx.app.log( "unit", unit + "" );
    Gdx.app.log( "scale", fontScale + "");

    if( width > singlePlayer.getLabel().getPrefWidth() && fontScale < 1f )
        fontScale = 1 / fontScale;

    if( width < singlePlayer.getLabel().getPrefWidth() && fontScale > 1f )
        fontScale = 1 / fontScale;

    singlePlayer.getLabel().setFontScale(fontScale);
    multiPlayer.getLabel().setFontScale(fontScale);
    options.getLabel().setFontScale(fontScale);
    exit.getLabel().setFontScale(fontScale);

    Gdx.app.log( "label-scaled-height", singlePlayer.getLabel().getHeight() + "" );
    Gdx.app.log( "label-scaled-prefheight", singlePlayer.getLabel().getPrefHeight() + "" );

    menuTable.add( singlePlayer ).size( width,unit).right().row();
    menuTable.add( multiPlayer ).size( width,unit).right().row();
    menuTable.add( options ).size( width,unit).right().row();
    menuTable.add( exit ).size( width,unit).right().row();

    exit.addListener( new ClickListener(){
        @Override
        public void clicked(InputEvent event, float x, float y){
            Gdx.app.exit();
        }
    });

    Gdx.input.setInputProcessor( stage );

    stage.addActor(rootTable);
}