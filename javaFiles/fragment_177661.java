ContentResolver resolver = context.getContentResolver();  
cursor = resolver.query(
            ContactsContract.Data.CONTENT_URI,
            null, null, null,
            ContactsContract.Contacts.DISPLAY_NAME);

//Now read data from cursor like 

while (cursor.moveToNext()) {
      long _id = cursor.getLong(cursor.getColumnIndex(ContactsContract.Data._ID));
      String displayName = cursor.getString(cursor.getColumnIndex(ContactsContract.Data.DISPLAY_NAME));
      String mimeType = cursor.getString(cursor.getColumnIndex(ContactsContract.Data.MIMETYPE));

      Log.d("Data", _id+ " "+ displayName + " " + mimeType );

}