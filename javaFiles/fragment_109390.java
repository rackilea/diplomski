cursor = mDb.query(DB_CONTACTS_NAME,
    new String[] {KEY_ID, KEY_LAST_NAME, KEY_FIRST_NAME, KEY_EMAIL_ADDRESS,
                 KEY_ORGANIZATION_NAME, KEY_LABEL, KEY_LABEL_POSITION},
    KEY_FIRST_NAME + "='" + first + "' AND " + KEY_LAST_NAME + "='" + last + "'",
    null, null, null, null
);