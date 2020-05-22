@Override
public Uri insert(Uri uri, ContentValues initialValues) {
    int match = URI_MATCHER.match(uri);

    ArrayList<Long> notifyRowIds = new ArrayList<Long>();
    Uri newUri = insertInternal(uri, match, initialValues, notifyRowIds);
    notifyMtp(notifyRowIds);

    // do not signal notification for MTP objects.
    // we will signal instead after file transfer is successful.
    if (newUri != null && match != MTP_OBJECTS) {
        getContext().getContentResolver().notifyChange(uri, null);
    }
    return newUri;
}