// I haven't even compiled this code, and even if it works, it's still insane.
// (others who know annotations better should feel free to edit or replace)
public void copyTileNetworkDataToCache (Object data, Cache<?> cache) {
  for (Field f : data.getClass().getFields()) {
    if (f.isAnnotationPresent(TileNetworkData.class)) {
      cache.save(f.get(data));
    }
  }
}