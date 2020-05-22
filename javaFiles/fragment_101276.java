public Map<Integer, List<ItemFeatureMapping>> getItemFeatures() {
    List<Item> allItems = getAllItems();
    Map<Integer, List<ItemFeatureMapping>> result = new HashMap<>(allItems.size(), 1f);
    Iterator<Item> iterator = allItems.iterator();
    while (iterator.hasNext()) {
        Item item = iterator.next();
        List<ItemFeatureMapping> itemFeatures = new ArrayList<>(item.getItemFeatures().size());

        Iterator<ItemFeatureMapping> iteratorFeature = item.getItemFeatures().iterator();
        while (iteratorFeature.hasNext()) {
            ItemFeatureMapping feature = iteratorFeature.next();
            itemFeatures.add(feature);
            iterator.remove();
        }
        result.put(item.getId(), itemFeatures);
        iterator.remove();
    }
    return result;
}