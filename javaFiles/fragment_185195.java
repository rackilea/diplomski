public class MainActivity extends Activity implements View.OnClickListener {

    private EditText testText;
    private Button testButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // initialize the UI elements
        testText = (EditText) findViewById(R.id.testText);
        testButton = (Button) findViewById(R.id.testButton);

        // set onClick Listener
        testButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()) {
            case R.id.testButton:                       
                // this will result in an error                                       
                System.out.println(testText.getText().toString().trim());
                break;
            default:
                break;
    }
}