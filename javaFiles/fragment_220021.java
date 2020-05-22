private static class PredefinedOrderComparator implements Comparator<Table> {

    public PredefinedOrderComparator() {

        // Initialize orderIndex here

    }

    private final Map<String, Integer> orderIndex;

    @Override public int compare(Table one, Table two) {
        return orderIndex.get(one.getTableName()) - orderIndex.get(two.getTableName());
    } 

}