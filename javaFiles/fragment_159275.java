public class YourActivity extends Activity {

    private ListView lv;

    public void onCreate(Bundle saveInstanceState) {
         setContentView(R.layout.your_layout);

         lv = (ListView) findViewById(R.id.your_list_view_id);

         // Instanciating an array list (you don't need to do this, 
         // you already have yours).
         List<String> your_array_list = new ArrayList<String>();
         your_array_list.add("foo");
         your_array_list.add("bar");

         // This is the array adapter, it takes the context of the activity as a 
         // first parameter, the type of list view as a second parameter and your 
         // array as a third parameter.
         ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(
                 this, 
                 android.R.layout.simple_list_item_1,
                 your_array_list );

         lv.setAdapter(arrayAdapter); 
    }
}