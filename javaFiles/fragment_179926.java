public static synchronized DatabaseHelper getInstance(Context context){
    if (mInstance == null){
        mInstance = new DatabaseHelper(context.getApplicationContext());
        try {
             mInstance.open();
        } catch (Exception exe) {}
    }
    return mInstance;
}