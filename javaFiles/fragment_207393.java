public MainMenuScreen(Game game) {
    this.game = game;
    app.log("Screen", "Main Menu Screen");
    camera= new OrthographicCamera();
    viewport = new FitViewport(MathsVsZombies.V_WIDTH, MathsVsZombies.V_HEIGHT, camera);
    stage = new Stage(viewport);
}