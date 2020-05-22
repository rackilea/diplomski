@Override
    public void onUpgrade(SQLiteDatabase db, int oldV, int newV) {
        if (newV > oldV) {
            db.execSQL("ALTER TABLE " + TABLE_QUEST + " ADD COLUMN " + KEY_ID2 + " INTEGER DEFAULT 0");
        }
    }