public class MyTask extends EnhancedAsyncTask<Param,Integer,MyResult> {
    MyParam1 param1;
    MyParam2 param2;

    public MyTask( MyParam1 param1, MyParam2 param2 ) {
        this.param1 = param;
        this.param2 = param2;
    }

    protected MyResult doInBackground( Param... params ) {
        // do server work here
        server.send( param1, param2 );
    }

    protected void success( MyResult result ) {
        // do Update of the UI
    }

    protected void handleException( Exception ex ) {
       // show an error here
    }
}

// Now to use this AsyncTask you would do something like this:

MyTask task = new MyTask( param1, param2 ).execute();