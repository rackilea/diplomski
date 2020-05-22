public long create(Contact contact) {
    ContentValues contactValues = buildContentValues(contact);

    long result;    
    try {
        result = getDb().insert(CONTACTS_TABLE_NAME, null, contactValues);
    } catch (SQLiteConstraintException sce) {
        sce.printStackTrace();
        log.debug("Error inserting:" + contact, sce);
        result = getDb().update(CONTACTS_TABLE_NAME, contactValues, COLUMN_ID + "=" + contact.userInfo.id, null);
    }

    return result;
}