public class PullToRefreshActivity extends AppCompatActivity {
private LinkedList<String> mListItems;
PullToRefreshListView listView;

/** Called when the activity is first created. */
@Override
public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.pull_to_refresh);
    listView = (PullToRefreshListView) findViewById(R.id.list_view); 
    // Set a listener to be invoked when the list should be refreshed.
    listView.setOnRefreshListener(new PullToRefreshListView.OnRefreshListener() {
        @Override
        public void onRefresh() {
            // Do work to refresh the list here.
            new GetDataTask().execute();
        }
    });

    mListItems = new LinkedList<String>();
    mListItems.addAll(Arrays.asList(mStrings));

    ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
            android.R.layout.simple_list_item_1, mListItems);

    listView.setAdapter(adapter);
}