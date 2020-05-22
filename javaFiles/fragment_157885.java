// Create AtlasRegion instance according the given <atlasRegionName>
final String atlasRegionName = "regionName";
AtlasRegion atlasRegion = atlas.findRegion(atlasRegionName);
// adjust your sprite position and dimensions here
final float xPos = 0;
final float yPos = 0;
final float w = asset.getWidth();
final float h = asset.getHeight();
// create sprite from given <atlasRegion>, with given dimensions <w> and <h>
// on the position of the given coordinates <xPos> and <yPos>
Sprite spr = new Sprite(atlasRegion, w, h, xPos, yPos);