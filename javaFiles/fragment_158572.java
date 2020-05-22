public void getContactInfo(long contactId) {

    Uri uri = Data.CONTENT_URI;

    String[] projection = new String[]{
            Data.CONTACT_ID,
            Data.DISPLAY_NAME,
            Data.MIMETYPE,
            Data.DATA1}; // you can get additional info if needed in Data.DATA2, DATA3, etc.

    // get all relevant info about the contact
    String selection = Data.CONTACT_ID + "=? AND " + Data.MIMETYPE + " IN (?,?,?,?)"; // you can add more question marks if you need more MIMETYPES
    String[] selectionArgs = new String[]{String.valueOf(contactId), Phone.CONTENT_ITEM_TYPE, Email.CONTENT_ITEM_TYPE, Event.CONTENT_ITEM_TYPE, StructuredPostal.CONTENT_ITEM_TYPE};

    Cursor cursor = getContentResolver().query(uri, projection, selection, selectionArgs, null);

    while (cursor.moveToNext()) {
        String name = cursor.getString(1);
        String mimetype = cursor.getString(2);
        String data = cursor.getString(3);

        // use the mimetype to figure out what kind of info is in this row

        Log.i("Contact Info", contactId + "=> " + name + " - " + mimetype + ": " + data);
    }
    cursor.close();
}