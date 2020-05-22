private static final Ordering<String> PRODUCT_ORDER = Ordering
        .explicit("men","ladies")
        .reverse();


private static void testGuavaOrdering() {
    SortedSetMultimap<Integer, String> onlineAreaPriorityCountMap = TreeMultimap
            .create(Collections.reverseOrder(),
                    Comparator.comparing(String::toLowerCase, PRODUCT_ORDER));
    onlineAreaPriorityCountMap.put(1, "Men");
    onlineAreaPriorityCountMap.put(1, "men");
    onlineAreaPriorityCountMap.put(1, "Ladies");
    onlineAreaPriorityCountMap.put(1, "ladies");
    System.out.println(onlineAreaPriorityCountMap.values().iterator().next());
}