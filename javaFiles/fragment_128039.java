@Override
public Cursor query(Uri uri, String[] proj, String sel, String[] selArgs, String sort) {
    switch (MATCHER.match(uri)) {
        case JOIN_DIR_TYPE:
            return queryJoin(uri, proj, sel, selArgs, sort)
            break;
            // ...
        default:
            throw new IllegalArgumentException("Unexpected uri: " + uri);
    }
    // ...
}