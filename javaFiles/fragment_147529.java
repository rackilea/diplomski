private static final int CTE_ALL = 1;
private static final int CTE_FIND = 2;
private static final UriMatcher uriMatcher = new UriMatcher(UriMatcher.NO_MATCH);
static {
    uriMatcher.addURI(PROVIDER_NAME, "cte", CTE_ALL);
    uriMatcher.addURI(PROVIDER_NAME, "cte/*", CTE_FIND);
}