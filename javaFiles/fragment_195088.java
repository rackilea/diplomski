public class TestActivity extends Activity{

    private String[] id;
    private TextView[] textViews = new TextView[2];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.testactivity);

        int temp;
        id = new String[]{"name", "address"};

        for(int i=0; i<id.length; i++){
           temp = getResources().getIdentifier(id[i], "id", getPackageName());
           textViews[i] = (TextView)findViewById(temp);        
           textViews[i].setText("Text Changed");
        }
    }