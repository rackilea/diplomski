MyDatabaseHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.db = new MyDatabaseHelper(getApplicationContext());
        setContentView(R.layout.desc_list_layout);

        setListAdapter(new DescriptionAdapter(this, 
                android.R.layout.simple_list_item_1,
                R.id.textView1, db.getAllDescriptionNames()));
        db.close();
    }