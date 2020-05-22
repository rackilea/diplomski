public class YourActivity extends Activity {
    ArrayList<Item> laktoseList = new ArrayList<Item>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //add your objects to list
        laktoseList.add(new Item("Milch", "15"));
        laktoseList.add(new Item("Jogurht", "11"));
        laktoseList.add(new Item("Woot", "19.5"));

        ListView listView = (ListView) findViewById(R.id.your_listview);

        ItemListAdapter adapter = new ItemListAdapter(this, list_item_laktose, laktoseList);
        listView.setAdapter(adapter);
    }
}