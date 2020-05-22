public class MyActivity extends Activity implements MyAdapterListener{
    private ExpandableListView expandableListView1;
    private MyAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        expandableListView1 = (ExpandableListView) findViewById(R.id.expandableListView1);
        adapter = new MyAdapter(this);
        expandableListView1.setAdapter(adapter);
    }
    @Override
    public void doRefresh() {
        adapter.notifyDataSetChanged();
    }

}