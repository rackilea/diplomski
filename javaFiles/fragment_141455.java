public Sprite createAndLoadSimpleSprite(String name,
    SimpleBaseGameActivity activity, int width, int height) {

BitmapTextureAtlas atlasForBGSprite = new BitmapTextureAtlas(
        activity.getTextureManager(), width, height);
TextureRegion backgroundSpriteTextureRegion = BitmapTextureAtlasTextureRegionFactory
        .createFromAsset(atlasForBGSprite, activity, name, 0, 0);
activity.getTextureManager().loadTexture(atlasForBGSprite);

Sprite sprite = new Sprite(0, 0, backgroundSpriteTextureRegion,
        activity.getVertexBufferObjectManager());

return sprite;

}