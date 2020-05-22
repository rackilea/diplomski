public class ChooseNumber1 extends AppCompatActivity {

    private ArrayAdapter<String> mobileNumberAdapter;
    private ArrayList<String> mobileNumbersList = new ArrayList<>();
    private ListView mobileNumberListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_number1);

        ...

        mobileNumberListView = (ListView) findViewById(R.id.listViewNumberList);

        mobileNumbersList = getIntent().getStringArrayListExtra("mobileNumbers");
        if(mobileNumbersList != null) {
            mobileNumberAdapter = new ArrayAdapter<String>(this,
                                                           R.layout.list_item_numbers,
                                                           R.id.list_item_number_textview,
                                                           mobileNumbersList);
            mobileNumberListView.setAdapter(mobileNumberAdapter);
        }
    }
}