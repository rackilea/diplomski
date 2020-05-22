public QueryBuilder with(String property, String value) {
    return with(property, value, CompareOperator.EQUAL, true);
}

public QueryBuilder with(String property, String value, 
                         CompareOperator compareOperator, 
                         boolean ignoreCase) {
    ...
}