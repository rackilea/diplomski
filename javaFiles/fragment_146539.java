//  Find contact based on name.
        //
        ContentResolver cr = getContentResolver();
        Cursor cursor = cr.query(ContactsContract.Contacts.CONTENT_URI, null,
            "DISPLAY_NAME = '" + NAME + "'", null, null);
        if (cursor.moveToFirst()) {
            String contactId =
                cursor.getString(cursor.getColumnIndex(ContactsContract.Contacts._ID));
            //
            //  Get all phone numbers.
            //
            Cursor phones = cr.query(Phone.CONTENT_URI, null,
                Phone.CONTACT_ID + " = " + contactId, null, null);
            while (phones.moveToNext()) {
                String number = phones.getString(phones.getColumnIndex(Phone.NUMBER));
                int type = phones.getInt(phones.getColumnIndex(Phone.TYPE));
                switch (type) {
                    case Phone.TYPE_HOME:
                        // do something with the Home number here...
                        break;
                    case Phone.TYPE_MOBILE:
                        // do something with the Mobile number here...
                        break;
                    case Phone.TYPE_WORK:
                        // do something with the Work number here...
                        break;
                    }
            }
            phones.close();
         }
    cursor.close();