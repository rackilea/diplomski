public class MainActivity extends AppCompatActivity {

    ListView lv1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Initialize the list view
        lv1 = (ListView) findViewById(R.id.mainlist);

        //Add the List data
        //as the array is stored starting with 0, the Layouts will be having 0th position, Intents being 1 and so on..
        String[] sessiontuts = new String[]{"Activity 1", "Activity2"};

        //use the Simple array adapter
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,android.R.id.text1,sessiontuts);

        //now to bind the data to list, just set the adapter we just created to the listview,
        lv1.setAdapter(adapter);

        //we need to have click listner on the particular item,
        //all the items in list will have a position starting from 0 to n,
        //so, write the intent code to launch particular activity depending on list item position
        lv1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int pos, long l) {
                //using switch case, to check the condition.
                switch (pos){
                    case 0:
                        startActivity(new Intent(getApplicationContext(), Act1.class));
                        break;
                    case 1:
                        startActivity(new Intent(getApplicationContext(), Act2.class));
                        break;
                }
            }
        });
    }
}