public class MainActivity extends Activity {

        // Use a unique request code for each use case 
        private static final int REQUEST_CODE_EXAMPLE = 0x9988; 

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);

            // Create an Intent to start AnotherActivity
            final Intent intent = new Intent(this, AnotherActivity.class);

            // Start AnotherActivity with the request code
            startActivityForResult(intent, REQUEST_CODE_EXAMPLE);
        }

        //-------- When a result is returned from another Activity onActivityResult is called.--------- //
        @Override
        public void onActivityResult(int requestCode, int resultCode, Intent data) {
            super.onActivityResult(requestCode, resultCode, data);

            // First we need to check if the requestCode matches the one we used.
            if(requestCode == REQUEST_CODE_EXAMPLE) {

                // The resultCode is set by the AnotherActivity
                // By convention RESULT_OK means that what ever
                // AnotherActivity did was successful
                if(resultCode == Activity.RESULT_OK) {
                    // Get the result from the returned Intent
                    final String result = data.getStringExtra(AnotherActivity.EXTRA_DATA);

                    // Use the data - in this case, display it in a Toast.
                    Toast.makeText(this, "Result: " + result, Toast.LENGTH_LONG).show();
                } else {
                    // AnotherActivity was not successful. No data to retrieve.
                }
            }
        }
    }