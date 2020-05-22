public class Activity1 extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Map<Integer, String> map = new LinkedHashMap<Integer, String>();
        map.put(1, "ONE");
        map.put(2, "TWO");
        map.put(3, "THREE");

        ArrayList<Integer> keys = new ArrayList<Integer>();
        ArrayList<String> values = new ArrayList<String>();
        for (Map.Entry<Integer, String> entry : map.entrySet()) {
            keys.add(entry.getKey());
            values.add(entry.getValue());
        }

        Intent intent = new Intent(this, Activity2.class);
        intent.putExtra("KEYS", keys);
        intent.putExtra("VALUES", values);

        startActivity(intent);
    }
}