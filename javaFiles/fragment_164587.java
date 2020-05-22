public Cursor GetContacts(String[] ids)
{
    ContentResolver cr = getContentResolver();

    try
    {
        Uri uri = ContactsContract.Contacts.CONTENT_URI;

        String[] projection = new String[] {
                ContactsContract.Contacts._ID,
                ContactsContract.Contacts.DISPLAY_NAME,
                ContactsContract.Contacts.HAS_PHONE_NUMBER
        };

        String where = ContactsContract.Contacts._ID + " IN (?)";

        String[] selectionArgs = {StringUtils.join(ids, ", ")};

        String sortOrder = ContactsContract.Contacts.DISPLAY_NAME;

        return cr.query(uri, projection, where, selectionArgs, sortOrder);
    }
    catch (Exception ex)
    {
    String message = ex.getMessage();
    Log.e("mine", "Error: " + message, ex);

    return null;
    }