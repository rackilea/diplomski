public class DestinationActivity extends Activity {

    // let your callers know how to pass you the information you need
    public static final String EXTRA_N = "n";

    private TextView resultText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_destination);

        resultText = (TextView) findViewById(R.id.resultText);

        // get the information you was passed
        Intent intent = getIntent();
        String n = intent.getStringExtra(EXTRA_N);

        // do your transformation using the other class
        String example = DifferentClass.getStringexample(n);

        // display the transformed string
        resultText.setText(example);    
    }

    // ... 
}