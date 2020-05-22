public class SearchActivity extends Activity{
    ArrayAdapter<String> adapter2;
    ArrayList<String> city_values = new ArrayList<String>();

      @Override
        public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.search_layout)

            city_values.add("your content");

           adapter2 = new ArrayAdapter<String> (this,android.R.layout.simple_spinner_item, city_values);
           adapter2.setDropDownViewResource(R.layout.city_spinner_layout);
           cityspinner.setAdapter(adapter2);