public class AsyncTaskExampleActivity extends Activity 
{
        protected TextView _percentField;
        protected Button _cancelButton;
        protected InitTask _initTask;
        ProgressDialog pd;

    @Override
    public void onCreate( Bundle savedInstanceState ) 
    {
        super.onCreate(savedInstanceState);

        setContentView( R.layout.main );

        _percentField = ( TextView ) findViewById( R.id.percent_field );
        _cancelButton = ( Button ) findViewById( R.id.cancel_button );
        _cancelButton.setOnClickListener( new CancelButtonListener() );

        _initTask = new InitTask();


         pd = ProgressDialog.show(AsyncTaskExampleActivity.this, "Loading", "Please Wait");


        _initTask.execute( this );
    }

    protected class CancelButtonListener implements View.OnClickListener 
    {
                public void onClick(View v) {
                        _initTask.cancel(true);
                }
    }

    /**
     * sub-class of AsyncTask
     */
    protected class InitTask extends AsyncTask<Context, Integer, String>
    {
        // -- run intensive processes here
        // -- notice that the datatype of the first param in the class definition matches the param passed to this method 
        // -- and that the datatype of the last param in the class definition matches the return type of this method
                @Override
                protected String doInBackground( Context... params ) 
                {
                        //-- on every iteration
                        //-- runs a while loop that causes the thread to sleep for 50 milliseconds 
                        //-- publishes the progress - calls the onProgressUpdate handler defined below
                        //-- and increments the counter variable i by one
                        int i = 0;
                        while( i <= 50 ) 
                        {
                                try{
                                        Thread.sleep( 50 );
                                        publishProgress( i );
                                        i++;
                                } catch( Exception e ){
                                        Log.i("makemachine", e.getMessage() );
                                }
                        }
                        pd.dismiss(); 
                        return "COMPLETE!";
                }

                // -- gets called just before thread begins
                @Override
                protected void onPreExecute() 
                {
                        Log.i( "makemachine", "onPreExecute()" );

                        super.onPreExecute();

                }

                // -- called from the publish progress 
                // -- notice that the datatype of the second param gets passed to this method
                @Override
                protected void onProgressUpdate(Integer... values) 
                {
                        super.onProgressUpdate(values);
                        Log.i( "makemachine", "onProgressUpdate(): " +  String.valueOf( values[0] ) );
                        _percentField.setText( ( values[0] * 2 ) + "%");
                        _percentField.setTextSize( values[0] );
                }

                // -- called if the cancel button is pressed
                @Override
                protected void onCancelled()
                {
                        super.onCancelled();
                        Log.i( "makemachine", "onCancelled()" );
                        _percentField.setText( "Cancelled!" );
                        _percentField.setTextColor( 0xFFFF0000 );
                }

                // -- called as soon as doInBackground method completes
                // -- notice that the third param gets passed to this method
                @Override
                protected void onPostExecute( String result ) 
                {

                        super.onPostExecute(result);
                        Log.i( "makemachine", "onPostExecute(): " + result );
                        _percentField.setText( result );
                        _percentField.setTextColor( 0xFF69adea );
                        _cancelButton.setVisibility( View.INVISIBLE );
                }
    }    
}