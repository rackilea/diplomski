public DbHelper(@Nullable Context context) {

    super(context, DB_NAME, null, 1);
    assert context != null;
    this.mContext = context;
    DB_PATH = context.getApplicationInfo().dataDir + "/databases/";
    if (!checkDataBase()) {
        try {
            createDataBase();
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("Unable to Copy Database");
        }
    }
    openDataBase();        
}