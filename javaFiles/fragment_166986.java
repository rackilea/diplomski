@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    ListView lv = (ListView)findViewById(R.id.listView);

    String final parameter = "123"; //<--

    lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            item = parent.getItemAtPosition(position).toString(); //<--
            // TODO1
            System.out.println(parameter)
        }

}
// TODO2

private String item = null;

public String getLastClickedItem(){
    return item;
}