public static Query buildQueryFromArgs(String type, List<Filter> filterList){
    Query resultQuery = new Query(type);
    for (Filter f : filterList){
        resultQuery = resultQuery.setFilter(f);
    }
    return resultQuery;
}