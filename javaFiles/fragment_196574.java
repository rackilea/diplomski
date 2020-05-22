public static Cursor getContactsOfGroup(Group group) {
    // getting ids of contacts that are in this specific group
    String where = ContactsContract.CommonDataKinds.GroupMembership.GROUP_ROW_ID + "="
            + group.id + " AND "
            + ContactsContract.CommonDataKinds.GroupMembership.MIMETYPE + "='"
            + ContactsContract.CommonDataKinds.GroupMembership.CONTENT_ITEM_TYPE + "'";

    Cursor query = context.getContentResolver().query(
            ContactsContract.Data.CONTENT_URI,
            new String[] {
                    ContactsContract.CommonDataKinds.GroupMembership.CONTACT_ID
            }, where, null, ContactsContract.Data.DISPLAY_NAME + " COLLATE LOCALIZED ASC");

    String ids = "";
    for (query.moveToFirst(); !query.isAfterLast(); query.moveToNext()) {
        ids += "," + query.getString(0);
    }
    if (ids.length() > 0) {
        ids = ids.substring(1);
    }

    // getting all of information of contacts. it fetches all of number from every one
    String[] projection = new String[]{
            "_id",
            "contact_id",
            "lookup",
            "display_name",
            "data1",
            "photo_id",
            "data2", // number type: 1:home, 2:mobile, 3: work, else : other
    };
    String selection = "mimetype ='" + ContactsContract.CommonDataKinds.Phone.CONTENT_ITEM_TYPE + "'"
            + " AND account_name='" + group.accountName + "' AND account_type='" + group.accountType + "'"
            + " AND contact_id in (" + ids + ")";

    return context.getContentResolver().query(BASE_URI, projection, selection, null, null);
}