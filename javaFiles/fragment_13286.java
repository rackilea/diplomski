public class MyActivity extends Activity {

    EditText editText;
    TextView textView;

    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        //  Declare all widget controls.
         editText = (EditText) findViewById(R.id.txtEdit);
        Button button = (Button) findViewById(R.id.btnChange);
        textView = (TextView) findViewById(R.id.lblText);

        button.setOnClickListener(listener);
    }

    View.OnClickListener listener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            textView.setText(editText.getText().toString);
        }
    };
}