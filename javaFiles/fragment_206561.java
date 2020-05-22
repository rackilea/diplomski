List<List<Map.Entry<Integer, String>>> compareN(HashMap<Integer, String> map, int n) {
    return map.entrySet().stream()
              .map(entry -> listOfNAccompanyingEntriesThatSatisfyTheConditions(entry, emptyList(), map, n - 1))
              .filter(list -> !list.isEmpty())
              .collect(toList());
}