class CategoryCount {
    private static final String QUERY = "
        select category, count(*) 
        from table 
        group by category";

    private final String category;
    private final int count;

    public static Stream<CategoryCount> getAllCategoryCounts() {
        list<Object[]> results = runQuery(QUERY);
        return Arrays.stream(results).map(CategoryCount::new);
    }

    private CategoryCount(Object[] row) {
        category = (String)row[0];
        count = (int)row[1];
    }
}