...

map.setMapType(GoogleMap.MAP_TYPE_NONE);
TileOverlayOptions tileOverlay = new TileOverlayOptions();
tileOverlay.tileProvider(new CustomMapTileProvider());
map.addTileOverlay(tileOverlay).setZIndex(0);

...