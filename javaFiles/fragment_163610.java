public MainMenuScreen(MainClass mainClass) {
   game = mainClass;
   stage = new Stage();
   Gdx.input.setInputProcessor(stage);   // This call should be after initialisation of stage.
   background = new Texture(Gdx.files.internal("Background.png"));
   ...
   ...
}