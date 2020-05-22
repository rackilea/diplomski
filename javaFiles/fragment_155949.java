public class CommonConstants extends SearchViewActivity {
    View view;
    String searchedCon;
    MyDataProvider dp;
    HashMap constantsHashMap;
    ArrayList constantsHashMapKeys;


    //finds view and hashmap, passes to adapter to display
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_common_constants);

        dp = new MyDataProvider(this);
        ExpandableListView view;
        view = (ExpandableListView) findViewById(R.id.expandableList);

        constantsHashMap = dp.getCommonMap();
        constantsHashMapKeys = new ArrayList<String>(constantsHashMap.keySet());

        MyCustomAdapter adapter = new MyCustomAdapter(this, constantsHashMap, constantsHashMapKeys);
        view.setAdapter(adapter);

        int pos;
        Intent intent = getIntent();
        searchedCon = intent.getStringExtra("key");
        if(searchedCon != null){
            pos = handleIntent(intent);
            view.smoothScrollToPosition(pos);
            view.expandGroup(pos);

        }






//creates toolbar
        Toolbar myToolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);

    }

    private int handleIntent(Intent intent) {

        searchedCon = intent.getStringExtra("key");
        boolean exist = false;
        int i;

        for( i  = 0; i<constantsHashMapKeys.size();i++){
            if (constantsHashMapKeys.get(i).equals(searchedCon)) {
                exist = true;
                break;
            }
        }
        if(exist){
            return i;
        }else{
            return 0;
        }
    }



}