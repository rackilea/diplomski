public class StackOverflowActivity extends Activity {

    public static final int LOGIN_REQUEST = 100;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        Button btn = (Button) findViewById(R.id.button1);
        btn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent i = new Intent(StackOverflowActivity.this, Login.class);
                startActivityForResult(i, LOGIN_REQUEST);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode) {
        case LOGIN_REQUEST:
            // TODO implement UI refresh
            Toast.makeText(getApplicationContext(), "I am coming from the login activity!",
                    Toast.LENGTH_LONG).show();
            break;
        default:
            Toast.makeText(getApplicationContext(), "Unexpected request code!",
                    Toast.LENGTH_LONG).show();
            break;
        }

    }
}