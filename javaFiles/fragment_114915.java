Uri phoneUri = Uri.withAppendedPath(PhoneLookup.CONTENT_FILTER_URI, Uri.encode(origin));
Cursor phonesCursor = context.getContentResolver().query(phoneUri, new String[] {PhoneLookup.DISPLAY_NAME}, null, null, null);

if(phonesCursor != null && phonesCursor.moveToFirst()) {
    displayName = phonesCursor.getString(0); // this is the contact name
}//end if