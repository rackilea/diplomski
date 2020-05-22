Cursor query(Uri uri, String[] projection, String selection, String[] selectionArgs, String sortOrder) {
    int res = uriMatcher.match(uri);
    switch (res) {
        case CTE_ALL:
            //TODO create a results Cursor with all the CTE results
            break;
        case CTE_FIND:
            //TODO create a results Cursor with the single CTE requested
            break;
    }
    return results;
}