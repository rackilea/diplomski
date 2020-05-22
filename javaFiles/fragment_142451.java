private MainDS datasource;

@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    datasource = new MainDS(this); 
    setContentView(R.layout.activity_main);
}