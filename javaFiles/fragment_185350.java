public static AppDatabase getInstance(Context context){
    if(appDatabase!=null){ // <= ERROR HERE, should be == null
        appDatabase = Room.databaseBuilder(context.getApplicationContext(),
                AppDatabase.class, "database-name").build();
    }
    return appDatabase;

}