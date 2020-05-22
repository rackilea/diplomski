public class ListViewDemo extends ListActivity {

    ArrayList<String> listItems=new ArrayList<String>();
    ArrayAdapter<String> adapter;

    TextView theFact;
    String shareFact;


    @Override
    public void onCreate(Bundle icicle) {
        super.onCreate(icicle);
        setContentView(R.layout.main);

        theFact = (TextView) findViewById(R.id.tvContent)
        shareFact = theFact.getText().toString();

        adapter=new ArrayAdapter<String>(this,
        android.R.layout.simple_list_item_1,
        listItems);
        setListAdapter(adapter);

        listItems.add(shareFact);
        adapter.notifyDataSetChanged();
    }
}