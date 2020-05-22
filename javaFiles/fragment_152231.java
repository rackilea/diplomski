ContentValues contentValues = new ContentValues();

contentValues.put(ContactsContract.Data.MIMETYPE, ContactsContract.CommonDataKinds.Phone.CONTENT_ITEM_TYPE);
contentValues.put(ContactsContract.CommonDataKinds.Phone.NUMBER, newNumber);
contentValues.put(ContactsContract.CommonDataKinds.Phone.TYPE, contactType);
contentValues.put(ContactsContract.Data.RAW_CONTACT_ID, contactId);


ArrayList<ContentProviderOperation> ops = new ArrayList<ContentProviderOperation>();

ops.add(ContentProviderOperation.newUpdate(
        ContactsContract.Data.CONTENT_URI)
        .withSelection(ContactsContract.Data.CONTACT_ID + "=?" + " AND " +  
        ContactsContract.Data.MIMETYPE + "=?"+ " AND " +  
        ContactsContract.CommonDataKinds.Organization.TYPE + "=?", new String[]{contactId,  
                                ContactsContract.CommonDataKinds.Phone.CONTENT_ITEM_TYPE,  
                                String.valueOf(contactType)}).withValues(contentValues).build());


try
{
            getContentResolver().applyBatch(ContactsContract.AUTHORITY, ops);
} 

catch (Exception e)
{

            Log.e("Error", e.getMessage());
}