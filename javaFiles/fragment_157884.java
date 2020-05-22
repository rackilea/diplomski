// load texture atlas
final String spriteSheet = "images/spritesheet.pack";
assetManager.load(spriteSheet, TextureAtlas.class);
// blocks until all assets are loaded
assetManager.finishedLoading();
// all assets are loaded, we can now create our TextureAtlas object
TextureAtlas atlas = assetManager.get(spriteSheet);
// (optional) enable texture filtering for pixel smoothing
for (Texture t: atlas.getTextures())
    t.setFilter(TextureFilter.Linear, TextureFilter.Linear);