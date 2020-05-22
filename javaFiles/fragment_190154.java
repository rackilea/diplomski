@Override
    public void onCreate(Bundle savedInstanceState) { 
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_yoursecondactivity);

        Intent i = getIntent();
        //now your item data are in i

        String TAG_ID_RS = i.getString("TAG_ID_RS");
        String TAG_NAMA_RS = i.getString("TAG_NAMA_RS");
        ....
        TextView namaView = (TextView)findViewById(R.id.yourNameView);
        namaView.setText(TAG_NAMA_RS);
        ....
    }