public Map<CatalogCd, Set<ItemUID>> filterResponse(Map<CatalogCd, Set<ItemUID>> availableItems,
        Map<CatalogCd, FilteringPreferences> filteringPrefs, Map<ItemUID, ItemInformation> itemDetailInformation) {
    Map<CatalogCd, Set<ItemUID>> resultingFilteredItemsMap = new HashMap<>();
    filteringPrefs.forEach((key, value) -> giveSuitableName(availableItems, itemDetailInformation,
            resultingFilteredItemsMap, key, value));
    return resultingFilteredItemsMap;
}

private void giveSuitableName(Map<CatalogCd, Set<ItemUID>> availableItems,
        Map<ItemUID, ItemInformation> itemDetailInformation, Map<CatalogCd, Set<ItemUID>> resultingFilteredItemsMap,
        CatalogCd catalogCdInRequest, FilteringPreferences filteringPreferences) {
    EnumSet<PrefA> prefA = filteringPreferences.getSupportedPrefAs();

    // get set of items for this catalogcd, loop over each itemuid, check from
    // itemDetailInformation map
    // to see if that itemuid's enumset has intersection with the enumset in
    // request's preference.
    availableItems.get(catalogCdInRequest).stream()
            .map(ai -> collectAndAddItems(itemDetailInformation, resultingFilteredItemsMap, catalogCdInRequest,
                    prefA, ai))
            .filter(s -> !s.isEmpty()).forEach(fs -> resultingFilteredItemsMap.put(catalogCdInRequest, fs));
}

private Set<ItemUID> collectAndAddItems(Map<ItemUID, ItemInformation> itemDetailInformation,
        Map<CatalogCd, Set<ItemUID>> resultingFilteredItemsMap, CatalogCd catalogCdInRequest, EnumSet<PrefA> prefA,
        ItemUID item) {
    EnumSet<PrefA> enumSetFromItemInfo = itemDetailInformation.get(item).getPrefAs();
    enumSetFromItemInfo.retainAll(prefA);
    Set<ItemUID> items = new HashSet<>();
    if (!enumSetFromItemInfo.isEmpty()) {
        if (resultingFilteredItemsMap.get(catalogCdInRequest) != null) {
            items = resultingFilteredItemsMap.get(catalogCdInRequest);
            items.add(item);
        } else {
            items = new HashSet<>(Arrays.asList(item));
        }
    }
    return items;
}