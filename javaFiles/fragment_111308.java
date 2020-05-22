public class PlaylistActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        ArrayList<String> lists = new ArrayList<>();
        lists.add("House");
        lists.add("MorningJams");
        lists.add("SundayTunes");
        ArrayAdapter<String> listAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, lists);

        ListView listView = findViewById(R.id.play_list);

        listView.setAdapter(listAdapter);
    }
}