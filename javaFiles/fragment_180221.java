@Override
    protected void onCreate(Bundle bundle) {
        // TODO Auto-generated method stub
        super.onCreate(bundle);
        setContentView(R.layout.test);
        Bundle exploded = this.getIntent().getExtras();
        if (this.getIntent().getExtras() != null) {
            long id0 = exploded.getLong("Pencil");
            String name0 = exploded.getString("Book");
            int phoneNumber0 = exploded.getInt("Laptop");
            double etc0 = exploded.getDouble("Nuclear_BOMB");
            .
            .
            .
            long X = exploded.getLong("X");
            String Y = exploded.getString("Y");
            int Z = exploded.getInt("Z");
            double W = exploded.getDouble("W");     
            }
        else {
            Message.message(this, "unread datas");
        }}