public String fetchTags() {
    ContentResolver contentResolver = this.getContentResolver();
    Cursor cursor = contentResolver.query(TagsContentProvider.CONTENT_URI,
        new String[] {
            Tags.COLUMN_TNAME
        }, null, null, null);
    cursor.getCount();

    final String SEPARATOR = ", ";

    StringBuilder builder = new StringBuilder();
    String prefix = "";

    while (cursor.moveToNext()) {
        builder.append(prefix);
        prefix = SEPARATOR;
        builder.append(cursor.getString(cursor.getColumnIndex(Tags.COLUMN_TNAME)));
    }

    String output = builder.toString()

    cursor.close();

    return output;
}