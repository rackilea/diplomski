public long insertQuote() {
            ContentValues initialValues = new ContentValues();
            initialValues.put(KEY_PHID, 100);
            initialValues.put(KEY_LAT, 28.5700);
            initialValues.put(KEY_LON, 77.3200);
            db.insert(DATABASE_TABLE, null, initialValues);
            initialValues.put(KEY_LAT, 28.4700);
            initialValues.put(KEY_LON, 77.0300);
            db.insert(DATABASE_TABLE, null, initialValues);
            initialValues.put(KEY_LAT, 27.1833);
            initialValues.put(KEY_LON, 78.0167);
            db.insert(DATABASE_TABLE, null, initialValues);
            initialValues.put(KEY_LAT, 26.4583);
            initialValues.put(KEY_LON, 80.3173);
            return db.insert(DATABASE_TABLE, null, initialValues);  
        }