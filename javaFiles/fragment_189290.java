public class MyActivity extends Activity {

EditText results;
private int number;
final EditText result = (EditText) findViewById(R.id.number);

@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_my);
    Button one = (Button) findViewById(R.id.button);
    one.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            BtnPressed(1);
        }
    });

}