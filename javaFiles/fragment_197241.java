private String getLookupKey(long contactId) {
    String lookupKey = null;
    String[] projection = new String[]{Contacts.LOOKUP_KEY};
    String selection = Contacts._ID + "=" + contactId;
    Cursor c = getContentResolver().query(Contacts.CONTENT_URI, projection, selection, null, null);
    if (c != null) {
        if (c.moveToFirst()) {
            lookupKey = c.getString(0);
        }
        c.close();
    }
    return lookupKey;
}

String lookupKey = getLookupKey(long contactId);
if (TextUtils.isEmpty(lookupKey)) {
    Log.e(TAG, "couldn't get lookupKey");
    return;
}
Uri shareUri = Uri.withAppendedPath(Contacts.CONTENT_VCARD_URI, lookupKey);

Intent intent = new Intent(Intent.ACTION_SEND);
intent.setType(Contacts.CONTENT_VCARD_TYPE);
intent.putExtra(Intent.EXTRA_STREAM, shareUri);
intent.putExtra(Intent.EXTRA_SUBJECT, "Share a contact");
startActivity(intent);