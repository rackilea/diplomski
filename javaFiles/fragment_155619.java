final Uri uri = ContactsContract.Contacts.CONTENT_URI;
    final String[] projection = new String[] {
            ContactsContract.Contacts._ID,
            ContactsContract.Contacts.DISPLAY_NAME,
            ContactsContract.Contacts.PHOTO_ID
    };

    String selection  = ContactsContract.Contacts.HAS_PHONE_NUMBER + " = '1'";
    final String sortOrder = ContactsContract.Contacts.DISPLAY_NAME + " COLLATE LOCALIZED ASC";
    Cursor cur = getContentResolver().query(uri, projection, selection,  null, sortOrder);


    if (cur.getCount() > 0) 
    {
        while (cur.moveToNext()) 
        {
            String Sid = cur.getString(cur.getColumnIndex(ContactsContract.Contacts._ID));
            String name = cur.getString(cur.getColumnIndex(ContactsContract.Contacts.DISPLAY_NAME));

        Log.e("contact", "...Contact Name ...." + name);
           // get the phone number
            Cursor pCur = getApplicationContext().getContentResolver().query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI, null,ContactsContract.CommonDataKinds.Phone.CONTACT_ID
                                + " = ?", new String[] { id }, null);
                 while (pCur.moveToNext()) {
                     number = pCur.getString(pCur .getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER));
                }
         pCur.close();

    }
    }
    cur.close();