public class MainActivity extends AppCompatActivity {

    ArrayList<HashMap<String, String>> list = new ArrayList<>();
    ListViewAdapters adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_default);

        adapter = new ListViewAdapters(this, list);
        listView.setAdapter(adapter);
    }

    private void showJSON2(String response) {
        ...
        list.clear();
        ...
        list.add(temp);
        ...

        // ListViewAdapters adapter = new ListViewAdapters(this, list);
        // listView.setAdapter(adapter);
        adapter.notifyDataSetChanged();
        ...
    }

}