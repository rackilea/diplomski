public long addWord(String word, String definition,String details) {
        ContentValues initialValues = new ContentValues();
        initialValues.put(KEY_WORD, word);
        initialValues.put(KEY_DEFINITION, definition);
        initialValues.put(KEY_DETAILS, details);

        return mDatabase.insert(FTS_VIRTUAL_TABLE, null, initialValues);
    }