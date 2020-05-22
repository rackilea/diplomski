String[] projection = {
            ContactsContract.Groups._ID,
            ContactsContract.Groups.TITLE,
            ContactsContract.Groups.ACCOUNT_NAME,
            ContactsContract.Groups.ACCOUNT_TYPE
    };
    return context.getContentResolver().query(
            ContactsContract.Groups.CONTENT_URI, projection, ContactsContract.Groups._ID + "=" + groupId , null, null
    );