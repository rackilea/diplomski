public void run() {
    //don't hard code things, use a constant for max progress value
    while ( myProgress<MAX_PROGRESS ){
        try{
            myHandle.sendMessage(myHandle.obtainMessage());
            //same
            Thread.sleep( SLEEP_TIME );
        } catch(Exception ex){
          //never live an empty catch statement, you are missing exceptions and
          //can't correct them
          Log.e( "MyCurrentClass", "Error during async data processing",e );
        }//catch
    }//while
    //start new activity here
    startActivity( MyClass.this, NewActivity.class );
}//met