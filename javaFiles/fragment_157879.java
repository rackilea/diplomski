Uri uri = data.getData();

        Cursor cursor = getContentResolver().query(uri, null, null, null, null);

        cursor.moveToFirst();
        name = cursor.getString(cursor.getColumnIndex(ContactsContract.Contacts.DISPLAY_NAME));

        cursor.moveToFirst();
        number = cursor.getString(cursor.getColumnIndex(Phone.NUMBER));