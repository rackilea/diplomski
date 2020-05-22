private FitViewport viewport;

    public GameScreen(AudioSnake audioSnake) {
        gameCore = audioSnake;
        viewport = new ScreenViewport(SCREEN_WIDTH_IN_PX, SCREEN_HEIGHT_IN_PX);
        gameStage = new Stage(viewport);