public static int duplicateHouses(ArrayList<String> houses) {
    // Make sure we only have 1 of each possible value
    Set<String> copy = new HashSet<>(houses);
    int duplicateCount = 0;
    // For each value, we want to filter the original 
    // list so that only matching values remain...
    for (String value : copy) {
        Stream<String> filter = houses.stream().filter((String t) -> t.equals(value));
        // If there is more then one, then there are duplicates...
        long count = filter.count();
        if (count > 1) {
            duplicateCount += count;
        }
    }
    return duplicateCount;
}