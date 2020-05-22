public class MainActivity extends Activity {
/** Called when the activity is first created. */
@Override
public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.main);
    ListView lv= (ListView)findViewById(R.id.listview);

    // create the grid item mapping
    String[] from = new String[] {"rowid", "col_1", "col_2"};
    int[] to = new int[] { R.id.item1, R.id.item2, R.id.item3 };


    // prepare the list of all records
    List<HashMap<String, String>> fillMaps = new ArrayList<HashMap<String, String>>();
    for(int i = 0; i < 10; i++){
        HashMap<String, String> map = new HashMap<String, String>();
        map.put("rowid", "" + i);
        map.put("col_1", "col_1_item_" + i);
        map.put("col_2", "col_2_item_" + i);
        fillMaps.add(map);
    }

    // fill in the grid_item layout
    SimpleAdapter adapter = new SimpleAdapter(this, fillMaps, R.layout.grid_item, from, to);
    lv.setAdapter(adapter);
}