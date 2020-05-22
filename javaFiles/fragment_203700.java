if (Integer.parseInt(hasPhone) > 0) { 
    Cursor phones = getContentResolver().query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI, null, ContactsContract.CommonDataKinds.Phone.CONTACT_ID +"="+ contactId, null, null); 
    phones.moveToNext(); //if you are interested in all contact phones do a while()
    String phoneNumber = phones.getString(phones.getColumnIndex( ContactsContract.CommonDataKinds.Phone.NUMBER));
    phones.close();
    contacts += cursor.getString(cursor.getColumnIndex(ContactsContract.Contacts.DISPLAY_NAME)) + ":" + phoneNumber + "|";
}