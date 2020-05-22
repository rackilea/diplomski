public class activity extends Activity {
    private TextView txt;
    Button startButton;
   @Override
   public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simple);
        txt = (TextView) findViewById(R.id.hello_text);
        startButton = (Button) findViewById(R.id.trigger);