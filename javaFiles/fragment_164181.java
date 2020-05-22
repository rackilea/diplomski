public static HashMap<Integer, List<StoreItem>> getStoreHashMap() {
    List<StoreItem> oldStores = getStoreList();
    HashMap<Integer, List<StoreItem>> dictionaryOfStore = new HashMap<Integer, List<StoreItem>>();

    for (StoreItem keyItem : oldStores) {
        if(!dictionaryOfStore.containsKey(keyItem.getStoreNumber())) {
            dictionaryOfStore.put(keyItem.getStoreNumber(), new ArrayList<StoreItem>());
        }
        dictionaryOfStore.get(keyItem.getStoreNumber()).add(keyItem);
    }

    return dictionaryOfStore;
}