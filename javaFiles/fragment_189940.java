@Override protected void onCreate(Bundle savedInstanceState){
    super.onCreate(savedInstanceState);
    // tell activity to use your custom layout:
    setContentView(R.layout.widget_show);      
    // set adapter etc   
    setListAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, PENS));
    getListView().setTextFilterEnabled(true);
}