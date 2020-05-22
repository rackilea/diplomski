public class Activity2 extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Intent intent = getIntent();
        List<Integer> keys = (List<Integer>) intent.getSerializableExtra("KEYS");
        List<String> values = (List<String>) intent.getSerializableExtra("VALUES");

        Map<Integer, String> map = new LinkedHashMap<Integer, String>();
        for (int i = 0, n = keys.size(); i < n; i++)
            map.put(keys.get(i), values.get(i));

        Log.i("Activity2",  "" + map);
    }
}