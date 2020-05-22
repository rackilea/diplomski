Cursor cur = getContentResolver().query(
    Phone.CONTENT_URI,
    new String[] {
        Phone.DISPLAY_NAME,
        Phone._ID
    },
    Phone.NORMALIZED_NUMBER + "=?",
    new String[] {
        ... //phone number placed here
    }, null);
    if (!cur.moveToFirst())
        return;

String id = cur.getString(cur.getColumnIndex(Phone._ID)));