// method to get name, contact id, and birthday
private Cursor getContactsBirthdays() {
    Uri uri = ContactsContract.Data.CONTENT_URI;

    String[] projection = new String[] {
            ContactsContract.Contacts.DISPLAY_NAME,
            ContactsContract.CommonDataKinds.Event.CONTACT_ID,
            ContactsContract.CommonDataKinds.Event.START_DATE
    };

    String where =
            ContactsContract.Data.MIMETYPE + "= ? AND " +
            ContactsContract.CommonDataKinds.Event.TYPE + "=" + 
            ContactsContract.CommonDataKinds.Event.TYPE_BIRTHDAY;
    String[] selectionArgs = new String[] { 
        ContactsContract.CommonDataKinds.Event.CONTENT_ITEM_TYPE
    };
    String sortOrder = null;
    return managedQuery(uri, projection, where, selectionArgs, sortOrder);
}

// iterate through all Contact's Birthdays and print in log
Cursor cursor = getContactsBirthdays();
int bDayColumn = cursor.getColumnIndex(ContactsContract.CommonDataKinds.Event.START_DATE);
while (cursor.moveToNext()) {
    String bDay = cursor.getString(bDayColumn);
    Log.d(TAG, "Birthday: " + bDay);
}