public class SortOrder {
    public static final Map<String, Integer> SORT_ORDER = initializeSortOrder();

    private static Map<String, Integer> initializeSortOrder() {
        List<String> orderedStrings = Arrays.asList(
                "A",
                "B",
                "D",
                "C",
                "E",
                "F"
        );
        Map<String, Integer> indexByString = new HashMap<>();
        for (int index = 0; index < orderedStrings.size(); ++index) {
            indexByString.put(orderedStrings.get(index), index);
        }
        return Collections.unmodifiableMap(indexByString);
    }
}