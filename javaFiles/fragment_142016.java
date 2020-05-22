private ListView listView1;

@Override
public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    String[] textString = {"Item1", "Item2", "Item3", "Item4"};
    int[] drawableIds = {R.drawable.img_id_row1, R.drawable.img_id_row2, R.drawable.img_id_row3, R.drawable.img_id_row4};

    CustomAdapter adapter = new CustomAdapter(this,  textString, drawableIds);


    listView1 = (ListView)findViewById(R.id.menuList);
    listView1.setAdapter(adapter);
}