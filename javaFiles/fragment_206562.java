private List<Map.Entry<Integer, String>>
                listOfNAccompanyingEntriesThatSatisfyTheConditions(Map.Entry<Integer, String> newEntry,
                                                                   List<Map.Entry<Integer, String>> selectedEntries,
                                                                   HashMap<Integer, String> originalMap,
                                                                   int n) {

        List<Map.Entry<Integer, String>> newSelectedEntries = join(newEntry, selectedEntries);

        if (n == 0) return satisifiesCondition(newSelectedEntries) ? selectedEntries : emptyList();

        return originalMap.entrySet().stream()
                          .filter(entry -> !selectedEntries.contains(entry) && !entry.equals(newEntry))
                          .map(entry -> listOfNAccompanyingEntriesThatSatisfyTheConditions(entry, newSelectedEntries, originalMap, n - 1))
                          .flatMap(Collection::stream)
                          .collect(toList());
    }