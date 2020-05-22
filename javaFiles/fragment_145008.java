public class MainActivity extends AppCompatActivity {

    public static final String STRING_RESULT_DATA_KEY = "result_data";

    private static final int REQUEST_CODE_SECOND_ACTIVITY = 101;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent intent = new Intent(this, SecondActivity.class);
        startActivityForResult(intent, REQUEST_CODE_SECOND_ACTIVITY);
    }

    public void function(String data) {
        EditText editText=(EditText)findViewById(R.id.EditText);
        editText.setText(data);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        // Check which request we're responding to
        if (requestCode == REQUEST_CODE_SECOND_ACTIVITY) {
            // Make sure the request was successful
            if (resultCode == RESULT_OK) {
                String dataString = data.getStringExtra(STRING_RESULT_DATA_KEY);
                function(dataString);
            }
        }
    }
}