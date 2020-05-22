public long insertQuote() {
        ContentValues initialValues = new ContentValues();
        initialValues.put(KEY_PHID, 100);
        initialValues.put(KEY_LAT1, 28.5700);
        initialValues.put(KEY_LAT2, 28.4700);
        initialValues.put(KEY_LAT3, 27.1833);
        initialValues.put(KEY_LAT4, 26.4583);

        initialValues.put(KEY_LON1, 77.3200);
        initialValues.put(KEY_LON2, 77.0300);
        initialValues.put(KEY_LON3, 78.0167);
        initialValues.put(KEY_LON4, 80.3173);

        return db.insert(DATABASE_TABLE, null, initialValues);
    }