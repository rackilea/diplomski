public DbHelper(@Nullable Context context) {

    super(context, DB_NAME, null, 1);

    assert context != null;
    DB_PATH = context.getApplicationInfo().dataDir + "/databases/";

    openDataBase(); //<<<<<<<<<< WILL ONLY WORK IF DB EXISTS
    this.mContext = context;

}