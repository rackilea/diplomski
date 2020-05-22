Cursor cursor = this.getReadableDatabase().query(
        BLOCKED_PHONES_TABLE,
        new String[] { KEY_ID },
        KEY_PHONE + " = ? AND " + KEY_IS_BLOCKED + " = 1" + ,
        new String[] { phone },
        null, null, null);