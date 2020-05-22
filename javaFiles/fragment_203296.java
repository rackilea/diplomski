@Override
protected void onCreate(Bundle savedInstanceState) {
    ...
    cache = new MyCache();
    cache.OpenOrCreateCache(this, "TheFolderNameForOpenOrSaveInAppCache");
}