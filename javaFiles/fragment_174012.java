public class MyActivity extends Activity{

    CustomListViewAdapter adapter;

    ...

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        new ReadWeatherJSONFeedTask().execute();

        rowItems = new ArrayList<RowItem>();

        listView = (ListView) findViewById(R.id.list);

        adapter = new CustomListViewAdapter(this,R.layout.activity_main, rowItems);

        listView.setAdapter(adapter);

    }


}