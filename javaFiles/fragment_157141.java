public class StringToJs extends AppCompatActivity {

    private StringToJson stringToJson;
    private ArrayList jsonArray;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_string_to_js);

        jsonArray = new ArrayList();
        for (int i = 0; i < 10; i++) {
            jsonArray.add(i);
        }

        stringToJson = new StringToJson(StringToJs.this);

        Log.e("JSON: ", stringToJson.getJson("my_name", "Cricket", "23", "1", jsonArray));


    }
}