private InputStream getPhotoInputStreamFromEmail(String email) {
    Uri u = null;
    String[] projection = { ContactsContract.CommonDataKinds.Photo.CONTACT_ID };
    String photoUri;
    ContentResolver cr = getContentResolver();
    Cursor emailCur = cr.query(ContactsContract.CommonDataKinds.Email.CONTENT_URI,
            projection,
            ContactsContract.CommonDataKinds.Email.ADDRESS + " = ?",
            new String[]{email}, null);
    if (emailCur.moveToNext()) {
        int columnIndex = emailCur.getColumnIndex(
                ContactsContract.CommonDataKinds.Photo.CONTACT_ID);
        long contactId = emailCur.getLong(columnIndex);

        u = ContentUris.withAppendedId(ContactsContract.Contacts.CONTENT_URI,
                contactId);
        return ContactsContract.Contacts.openContactPhotoInputStream(cr, u);
    }
    return null;
}