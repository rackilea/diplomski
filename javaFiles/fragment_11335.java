public class ContactView extends Activity {
private ListView listView;

@Override
protected void onCreate(Bundle savedInstanceState) {

    super.onCreate(savedInstanceState);
    setContentView(R.layout.list_view);


    this.listView = (ListView) findViewById(R.id.listView);
    DBAccess databaseAccess =  DBAccess.getInstance(this);
    databaseAccess.open();
    List<String> quotes = databaseAccess.getQuotes(getIntent().getStringExtra("ID_EXTRA"));
    databaseAccess.close();

    ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, quotes);
    this.listView.setAdapter(adapter);

}