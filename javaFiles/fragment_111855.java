public boolean contactExists(Context context, String number) {
    /// number is the phone number
    Uri lookupUri = Uri.withAppendedPath(
    PhoneLookup.CONTENT_FILTER_URI, 
    Uri.encode(number));
    String[] mPhoneNumberProjection = { PhoneLookup._ID, PhoneLookup.NUMBER, PhoneLookup.DISPLAY_NAME };
    Cursor cur = context.getContentResolver().query(lookupUri,mPhoneNumberProjection, null, null, null);
    try {
        if (cur.moveToFirst()) {
            return true;
        }
    } finally {
    if (cur != null)
        cur.close();
    } 
    return false;
 }