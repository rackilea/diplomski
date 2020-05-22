public class AddActivity extends Activity {
// https://source.android.com/source/code-style.html
// info -> mInfo; non-public, non-static field!
String[] mInfo =  new String[11];

@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.add_layout);

    TextView keyString = (TextView)findViewById(R.id.keyString);
    TextView site1 = (TextView)findViewById(R.id.site1);
    TextView site2 = (TextView)findViewById(R.id.site2);
    TextView site3 = (TextView)findViewById(R.id.site3);
    Button submit = (Button)findViewById(R.id.submit);
    ImageButton add1 = (ImageButton)findViewById(R.id.add1);
    ImageButton add2 = (ImageButton)findViewById(R.id.add2);
    ImageButton add3 = (ImageButton)findViewById(R.id.add3);

    add1.setOnClickListener(new View.OnClickListener() {
    public void onClick(View v) {
        add2.setVisibility(View.VISIBLE);
        site2.setVisibility(View.VISIBLE);
        }
    });

    submit.setOnClickListener(new View.OnClickListener() {
    public void onClick(View v) {
        submitEntry(mInfo);
        }
    });
}