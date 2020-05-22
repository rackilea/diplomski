ArrayList<HashMap<String, String>> data;
    private String[] titleArray,subItemArray;

@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.listview);
    ListView lv = (ListView)findViewById(R.id.listview);
    data = new ArrayList<HashMap<String, String>>();
    titleArray=new String[]{"Test1","Test2"};
    subItemArray=new String[]{"SubTest1","SubTest2"};
    for(int i=0;i<titleArray.length;i++){
        HashMap<String,String> datum = new HashMap<String, String>();
        datum.put("RouterName", titleArray[i]);
        datum.put("RouterIP", subItemArray[i]);
        data.add(datum);
    }
    SimpleAdapter adapter = new SimpleAdapter(this, data, android.R.layout.simple_list_item_2, new String[] {"RouterName", "RouterIP"}, new int[] {android.R.id.text1, android.R.id.text2});
    lv.setAdapter(adapter);
}