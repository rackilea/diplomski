@Override
public void show () {
    skin = new Skin (Gdx.files.internal("PlayButton.json"));
    button = new Button(skin);
    button.setPosition(330,600);
    button.setSize(240,240);
    button.addListener(new ClickListener(){
        @Override
        public void clicked(InputEvent event, float x, float y) {
            game.setScreen(new GameScreen(game));
            super.clicked(event, x, y);
        }
    });

    stage.addActor(button);
    Gdx.input.setInputProcessor(stage);
}

@Override
public void render (float delta) {

    Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
    Gdx.gl.glClearColor(1,1,1,1);

    stage.draw();
    stage.act();
}