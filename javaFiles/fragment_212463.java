ContactsList = new ArrayList<String>();
    ContactsNumbersList = new ArrayList<String>();

    HashSet<String> normalizedNumbersAlreadyFound = new HashSet<>();

    // Contacts Database queries

    Cursor cursor = getContentResolver().query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI, new String[] {ContactsContract.CommonDataKinds.Phone._ID, ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME, ContactsContract.CommonDataKinds.Phone.NUMBER}, null, null,  ContactsContract.CommonDataKinds.Phone.SORT_KEY_PRIMARY +" ASC");


    while (cursor.moveToNext())
    {
        String name = cursor.getString(cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME));
        String phoneNumber = cursor.getString(cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER));

        phoneNumber = phoneNumber.replace("-","");
        phoneNumber = phoneNumber.replace(" ","");
        phoneNumber = phoneNumber.replace("(","");
        phoneNumber = phoneNumber.replace(")","");

        if (normalizedNumbersAlreadyFound.add(phoneNumber))
        {
            ContactsList.add(name);
            ContactsNumbersList.add(phoneNumber);
        }

    }
    cursor.close();