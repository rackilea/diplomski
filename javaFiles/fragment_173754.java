private static long getOrCreateThreadIdInternal(Context context, Set<String> recipients) {
    Uri.Builder uriBuilder = Uri.parse("content://mms-sms/threadID").buildUpon();
    for (String recipient : recipients) {
        /*if (isEmailAddress(recipient)) {
            recipient = extractAddrSpec(recipient);
        }*/
        uriBuilder.appendQueryParameter("recipient", recipient);
    }
    Uri uri = uriBuilder.build();
    Cursor cursor = query(context.getContentResolver(), uri, new String[] {BaseColumns._ID}, null, null, null);
    if (cursor != null) {
        try {
            if (cursor.moveToFirst()) {
                return cursor.getLong(0);
            } else {
                Log.e("JavaScriptInterface", "getOrCreateThreadId returned no rows!");
            }
        } finally {
            cursor.close();
        }
    }
    Log.e("JavaScriptInterface", "getOrCreateThreadId failed with uri " + uri.toString());
    throw new IllegalArgumentException("Unable to find or allocate a thread ID.");
}

private static Cursor query(ContentResolver resolver, Uri uri, String[] projection,
                            String selection, String[] selectionArgs, String sortOrder) {
    try {
        return resolver.query(uri, projection, selection, selectionArgs, sortOrder);
    } catch (Exception e) {
        Log.e("JavaScriptInterface", "Catch an exception when query: ", e);
        return null;
    }
}