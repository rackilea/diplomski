String contactNumber = "Your Contact Number"; // to change with real value

Cursor cursor = context.getContentResolver ()
    .query (
        ContactsContract.Data.CONTENT_URI,
        new String [] { ContactsContract.Data._ID },
        ContactsContract.RawContacts.ACCOUNT_TYPE + " = 'com.whatsapp' " +
            "AND " + ContactsContract.Data.MIMETYPE + " = 'vnd.android.cursor.item/vnd.com.whatsapp.video.call' " +
            "AND " + ContactsContract.CommonDataKinds.Phone.NUMBER + " LIKE '%" + contactNumber + "%'",
        null,
        ContactsContract.Contacts.DISPLAY_NAME
    );

if (cursor == null) {
    // throw an exception
}

long id = -1;
while (cursor.moveToNext()) {
    id = cursor.getLong (cursor.getColumnIndex (ContactsContract.Data._ID));
}

if (!cursor.isClosed ()) {
    cursor.close ();
}