for (Set<I> itemset : candidateList2) {
    Integer value = supportCountMap.get(itemset);
    if (value == null) {
        value = 0;
    }
    supportCountMap.put(itemset, value + 1);
}