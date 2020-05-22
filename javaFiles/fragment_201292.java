public class my_map_activity extends Activity {

    ArrayList<String> name = null;
    ArrayList<String> gender = null;
    ArrayList<String> latitude = null;
    ArrayList<String> longitude = null;
    Context activity_context = null;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        ListView user_listview = (ListView) findViewById(R.id.user_listview);

        name = new ArrayList<String>();
        gender = new ArrayList<String>();
        latitude = new ArrayList<String>();
        longitude = new ArrayList<String>();

        for (int i = 0; i < 10; i++) {
            name.add ("test user " + i);
            gender.add ("Male");
            latitude.add (""+ i);
            longitude.add (""+ i);
        }

        custom_adapter list_adapter = new custom_adapter (this, android.R.layout.simple_list_item_1, name, gender, latitude, longitude);
        user_listview.setAdapter(list_adapter);
    }
}