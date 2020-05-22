private DBHelper dbHelper = null;

@Override
protected void onDestroy() {
    super.onDestroy();
    if (dbHelper != null) {
        OpenHelperManager.releaseHelper();
        dbHelper = null;
    }
}

private DBHelper getHelper() {
    if (dbHelper == null) {
        dbHelper = (DBHelper)OpenHelperManager.getHelper(this, DBHelper.class);
    }
    return dbHelper;
}