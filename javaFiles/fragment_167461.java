//create the first tilesOverlay
final MapTileProviderBasic tileProvider = new MapTileProviderBasic(getApplicationContext());
final ITileSource tileSource = new XYTileSource("MyCustomTiles", null, 1, 16, 256, ".png",
        "http://a.url.to/custom-tiles/");
tileProvider.setTileSource(tileSource);
final TilesOverlay tilesOverlay = new TilesOverlay(tileProvider, this.getBaseContext());
tilesOverlay.setLoadingBackgroundColor(Color.TRANSPARENT);

//create the second one
final MapTileProviderBasic anotherTileProvider = new MapTileProviderBasic(getApplicationContext());
final ITileSource anotherTileSource = new XYTileSource("MyCustomTiles", null, 1, 16, 256, ".png",
        "http://a.secondurl.to/custom-tiles/");
anotherTileProvider.setTileSource(anotherTileSource);
final TilesOverlay secondTilesOverlay = new TilesOverlay(anotherTileProvider, this.getBaseContext());
secondTilesOverlay.setLoadingBackgroundColor(Color.TRANSPARENT);

// add the first tilesOverlay to the list
osmv.getOverlays().add(tilesOverlay);

// add the second tilesOverlay to the list
osmv.getOverlays().add(secondTilesOverlay);