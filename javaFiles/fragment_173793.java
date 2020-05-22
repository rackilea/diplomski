public void onLoadResources() {
     this.mBitmapTextureAtlas = new BitmapTextureAtlas(512, 512,
           TextureOptions.BILINEAR_PREMULTIPLYALPHA);
    BitmapTextureAtlasTextureRegionFactory.setAssetBasePath("gfx/");

    this.mPlayerTextureRegion = BitmapTextureAtlasTextureRegionFactory
            .createFromAsset(this.mBitmapTextureAtlas, this, "Player.png",
            0, 0);
    this.mEngine.getTextureManager().loadTexture(this.mBitmapTextureAtlas);
    final int PlayerX = (int)(mCamera.getWidth() / 2);
    final int PlayerY = (int) ((mCamera.getHeight() - mPlayerTextureRegion
            .getHeight()) / 2);
    this.player = new Sprite(PlayerX, PlayerY, this.mPlayerTextureRegion);
    this.player.setScale(2);
    this.mMainScene = new Scene();
    this.mMainScene.setBackground(new ColorBackground(0.09804f, 0.6274f, 0.8784f));
    this.mMainScene.attachChild(this.player);
}

public Scene onLoadScene() {
    return mMainScene;
}