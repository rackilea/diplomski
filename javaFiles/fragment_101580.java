String number = "";

    ContentResolver cr = getContentResolver();
    Cursor cur = cr.query(ContactsContract.Contacts.CONTENT_URI,null,null, null, null);
    if (cur.getCount() > 0) {
        while (cur.moveToNext()) {
            String id = cur.getString(cur.getColumnIndex(ContactsContract.Contacts._ID));
            String name = cur.getString(cur.getColumnIndex(ContactsContract.Contacts.DISPLAY_NAME));

                if (Integer.parseInt(cur.getString(cur.getColumnIndex(ContactsContract.Contacts.HAS_PHONE_NUMBER))) > 0) {

                    Cursor pCur = cr.query(
                            ContactsContract.CommonDataKinds.Phone.CONTENT_URI, 
                            new String[]{ContactsContract.CommonDataKinds.Phone.NUMBER}, 
                            ContactsContract.CommonDataKinds.Phone.CONTACT_ID +" = ?", 
                            new String[]{id}, null);

                    while (pCur.moveToNext()) {
                        for(int i=0;i<pCur.getColumnCount();i++)
                            number = pCur.getString(i);

                    } 
                    pCur.close();
                    pCur = null;
                }

        }
    }
    cur.close();
    cur = null;
    cr = null;