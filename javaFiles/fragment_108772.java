public class MainActivity extends Activity {

    private CustomAdapter adapter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); 

        ListView lv = (ListView) findViewById(R.id.listView1);
        adapter = new CustomAdapter(this);
        lv.setAdapter(adapter);

        Button btnAdd_category = (Button) findViewById(R.id.recordAddCategory);
        btnAdd_category.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                adapter.addRow();
            }
        });
    }