private static final int JOIN_DIR_TYPE = 10;
private static final UriMatcher MATCHER = new UriMatcher(UriMatcher.NO_MATCH);
static {
    // ...
    MATCHER.addURI(
        MyContract.AUTHORITY,
        MyContract.Join.TABLE,
        JOIN_DIR_TYPE);
}