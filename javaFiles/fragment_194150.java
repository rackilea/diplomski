private RecyclerView recList;
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.order_coffee);
    recList = (RecyclerView) findViewById(R.id.cardList);
    recList.setHasFixedSize(true);
    recList.setLayoutManager(new LinearLayoutManager(this));
    shopList = new ArrayList<HashMap<String, String>>();
    new LoadAllProducts().execute();
}