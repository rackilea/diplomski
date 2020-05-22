Cursor contact = getContentResolver().query(ContactsContract.Contacts.CONTENT_URI, null, ContactsContract.Contacts._ID + "=?", new String[]{String.valueOf(148)}, null, null);
    if (contact != null && contact.moveToNext()) {
        String lookupKey = contact.getString(contact.getColumnIndex(ContactsContract.Contacts.LOOKUP_KEY));
        int contactId = contact.getInt(contact.getColumnIndex(ContactsContract.Contacts._ID));
        Uri contactUri = ContactsContract.Contacts.getLookupUri(contactId, lookupKey);

        Cursor calls = getContentResolver().query(CallLog.Calls.CONTENT_URI, null, CallLog.Calls.CACHED_LOOKUP_URI + "=?", new String[]{contactUri.toString()}, CallLog.Calls.DATE + " DESC");
        while (calls.moveToNext()) {
            Log.d(TAG, "type: " + calls.getString(calls.getColumnIndex(CallLog.Calls.TYPE)) + ", number: " + calls.getString(calls.getColumnIndex(CallLog.Calls.NUMBER)) + ", " + "cached_name: " + calls.getString(calls.getColumnIndex(CallLog.Calls.CACHED_NAME)) + ", " + "date: " + calls.getString(calls.getColumnIndex(CallLog.Calls.DATE)));
        }
    }