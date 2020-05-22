public class MainActivity extends ListActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        List<Item> items = new ArrayList<Item>();
        items.add(new Header("Header 1"));
        items.add(new ListItem("Text 1", "Rabble rabble"));
        items.add(new ListItem("Text 2", "Rabble rabble"));
        items.add(new ListItem("Text 3", "Rabble rabble"));
        items.add(new ListItem("Text 4", "Rabble rabble"));
        items.add(new Header("Header 2"));
        items.add(new ListItem("Text 5", "Rabble rabble"));
        items.add(new ListItem("Text 6", "Rabble rabble"));
        items.add(new ListItem("Text 7", "Rabble rabble"));
        items.add(new ListItem("Text 8", "Rabble rabble"));

        TwoTextArrayAdapter adapter = new TwoTextArrayAdapter(this, items);
        setListAdapter(adapter);
    }

}