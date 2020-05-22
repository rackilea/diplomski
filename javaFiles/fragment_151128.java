private boolean checkDatabase {
    File db = new File(mContext.getDatabasePath(DB_NAME).getPath());
    if(db.exists()) return true;
    File dir = new File(db.getParent());
    if (!dir.exists()) {
        dir.mkdirs();
    }
    return false;
}