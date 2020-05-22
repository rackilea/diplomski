public String getContactName(final String phoneNumber) 
{  
    Uri uri;
    String[] projection;
    mBaseUri = Contacts.Phones.CONTENT_FILTER_URL;
    projection = new String[] { android.provider.Contacts.People.NAME }; 
    try {
        Class<?> c =Class.forName("android.provider.ContactsContract$PhoneLookup");
        mBaseUri = (Uri) c.getField("CONTENT_FILTER_URI").get(mBaseUri);
        projection = new String[] { "display_name" };
    } 
    catch (Exception e) {
    }


    uri = Uri.withAppendedPath(mBaseUri, Uri.encode(phoneNumber)); 
    Cursor cursor = this.getContentResolver().query(uri, projection, null, null, null); 

    String contactName = "";

    if (cursor.moveToFirst()) 
    { 
        contactName = cursor.getString(0);
    } 

    cursor.close();
    cursor = null;

    return contactName; 
}