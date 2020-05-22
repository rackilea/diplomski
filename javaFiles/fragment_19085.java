class AssetManager {

    private Map<String, Object> assets = new HashMap<String, Object>();

    public void storeAsset(String key, Object asset) {
        assets.put(key, asset);
    }

    public <T> T getAsset(String key, Class<T> clazz) {
        return (T) assets.get(key);
    }

    public void freeAsset(String key) {
        assets.remove(key);
    }
}