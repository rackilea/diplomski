public class MyActivity extends Activity {

EditText results;
private int number;
private EditText result;

@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_my);
    result = (EditText) findViewById(R.id.number);
    Button one = (Button) findViewById(R.id.button);
    one.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            BtnPressed(1);
        }
    });

}