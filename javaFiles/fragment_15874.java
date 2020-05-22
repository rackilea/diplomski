public OptionScreen(com.MKgames.Game1 game1){
    this.game = game;

    camera = new OrthographicCamera();
    camera.setToOrtho(true, 1920, 1080);

    batch = new SpriteBatch();

    farmerX = 960-85;

    //This is what's missing
    FarmerAsset.load();

}