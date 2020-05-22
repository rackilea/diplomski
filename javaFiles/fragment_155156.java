try {
    mMenuTextureAtlas.build(new BlackPawnTextureAtlasBuilder<IBitmapTextureAtlasSource, BitmapTextureAtlas>(0, 0, 0));
    mMenuTextureAtlas.load();
} catch (TextureAtlasBuilderException e) {
    Debug.e(e);
}