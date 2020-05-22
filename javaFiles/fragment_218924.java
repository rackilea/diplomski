public MenuStateTest(GameStateManager gsm) {
    super(gsm);
    cam.setToOrtho(false, MyGame.WIDTH, MyGame.HEIGHT);

    fitViewport = new FitViewport(MyGame.WIDTH, MyGame.HEIGHT);

    stage = new Stage(fitViewport);
    Gdx.input.setInputProcessor(stage);
    font = new BitmapFont();
    skin = new Skin();

    buttonAtlas = new TextureAtlas("buttonTest.pack");
    skin.addRegions(buttonAtlas);
    textButtonStyle = new TextButton.TextButtonStyle();
    textButtonStyle.font = font;
    textButtonStyle.up = skin.getDrawable("1BBlock");
    textButtonStyle.checked = skin.getDrawable("T1BBlock");
    button = new TextButton("", textButtonStyle);
    stage.addActor(button);
    button.setPosition(20, 200);

    button2Atlas = new TextureAtlas("Button2Test.pack");
    skin.addRegions(button2Atlas);
    textButtonStyle = new TextButton.TextButtonStyle();
    textButtonStyle.font = font;
    textButtonStyle.up = skin.getDrawable("2BBlock");
    textButtonStyle.checked = skin.getDrawable("T2BBlock");
    button2 = new TextButton("", textButtonStyle);
    stage.addActor(button2);
    button2.setPosition(175, 200);

    button3Atlas = new TextureAtlas("Button3Test.pack");
    skin.addRegions(button3Atlas);
    textButtonStyle = new TextButton.TextButtonStyle();
    textButtonStyle.font = font;
    textButtonStyle.up = skin.getDrawable("3BBlock");
    textButtonStyle.checked = skin.getDrawable("T3BBlock");
    button3 = new TextButton("", textButtonStyle);
    stage.addActor(button3);
    button3.setPosition(330, 200);

    ButtonGroup buttons = new ButtonGroup(button1, button2, button3);
    buttons.setMaxCheckCount(1);
}

@Override
protected void handleInput() {

}

@Override
protected void update(float dt) {
    stage.getViewport().update(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
}