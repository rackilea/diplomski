public enum PaletteCache
{
    INSTANCE;

    private static HashMap<String, Integer> mCache;

    private PaletteCache() {
        loadCache();
    }

    public static PaletteCache getInstance() {
        return INSTANCE;
    }

    private static void loadCache() {
        // Load the HashMap from disk if present
    }

    public static int getVibrantColor(String itemName) {
        return mCache.get(itemName);
    }

    public static void setColor(String itemName, int color) {
        mCache.put(itemName, color);
    }

}