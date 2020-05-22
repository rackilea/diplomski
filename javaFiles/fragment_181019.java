public class MainActivity extends AppCompatActivity {
String userIn;

@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    String a = "Hello from";
    String b = "the other";
    String c = "SIDE!";
    String d = "What you don't like Adele?";



    final EditText editText = (EditText) findViewById(R.id.editText);
    TextView textView = (TextView) findViewById(R.id.viewText);

    editText.setOnEditorActionListener(new TextView.OnEditorActionListener() {
        @Override
        public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
            boolean handled = false;
            if (actionId == EditorInfo.IME_ACTION_SEND) {
                sendMessage();
                handled = true;
            }
            return handled;
        }

        private void sendMessage() {
            userIn = editText.getText().toString();
        }
    });

}