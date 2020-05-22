private Cursor getContacts(){
       Uri uri= ContactsContract.Contacts.CONTENT_URI;
       String[] projection=new String[]{ContactsContract.Contacts._ID,
            ContactsContract.Contacts.DISPLAY_NAME};
       String selection=ContactsContract.Contacts.IN_VISIBLE_GROUP + "= ?";
       String[] selectionArgs = new String[] { "1" };
       String sortOrder=ContactsContract.Contacts.DISPLAY_NAME + " COLLATE LOCALIZED ASC";
       Cursor out=getContentResolver().query(uri, projection, selection, selectionArgs, sortOrder);
       return out;
   }