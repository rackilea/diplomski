long mId = ...; 
mDatabaseHelper = DatabaseHelper.getInstance(context);
mDatabaseHelper.getThingyByIdAsync(mId, new Callback<Thingy>{
    @Override
    public void callback(Thingy thingy){
        //do whatever you want to do with thingy
    }
});