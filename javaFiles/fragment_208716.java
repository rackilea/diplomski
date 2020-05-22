public class AnotherActivity extends Activity {

        // Constant used to identify data sent between Activities.
        public static final String EXTRA_DATA = "EXTRA_DATA";

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_another);

            final View button = findViewById(R.id.button);
            // When this button is clicked we want to return a result
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    // Create a new Intent as container for the result
                    final Intent data = new Intent();

                    // Add the required data to be returned to the MainActivity
                    data.putExtra(EXTRA_DATA, "Some interesting data!");

                    // Set the resultCode to Activity.RESULT_OK to 
                    // indicate a success and attach the Intent
                    // which contains our result data
                    setResult(Activity.RESULT_OK, data); 

                    // With finish() we close the AnotherActivity to 
                    // return to MainActivity
                    finish();
                }
            });
        }

        @Override
        public void onBackPressed() {
            // When the user hits the back button set the resultCode 
            // to Activity.RESULT_CANCELED to indicate a failure
            setResult(Activity.RESULT_CANCELED);
            super.onBackPressed();
        }
    }