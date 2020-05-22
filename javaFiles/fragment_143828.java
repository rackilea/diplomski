public class MainActivity extends Activity implements OnClickListener{
    TextView myText = null;
    Button myBtnCancel = null;
    Button myBtnOK = null;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        myText = (TextView) findViewById(R.id.myText);
        myBtnCancel = (Button) findViewById(R.id.myBtnCancel);
        myBtnOK = (Button) findViewById(R.id.myBtnOK);
    }