@Override
    public boolean onCreate() {
        Context context = getContext();
        DBHelper = new DatabaseHelper(context);
        db = DBHelper.getWritableDatabase();
        return (db == null) ? false : true;
    }