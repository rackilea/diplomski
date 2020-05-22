public class RunTestProject extends Activity {

@Override
public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.main);  //whatever you want your layout to be
}

// getLanden() implementation goes here


public void KiesLandMenu(){
    ArrayList<Land> alleLanden = getLanden();
    arrAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_single_choice, alleLanden);

    Dialog dialog = new Dialog(this);
    dialog.setTitle("Kies land");
    dialog.setContentView(R.layout.withList); // The dialog layout
    ListView list = (ListView) dialog.findViewById(android.R.id.list); //note that it's not simply findViewById
    list.setAdapter(arrAdapter);
    list.setChoiceMode(ListView.CHOICE_MODE_SINGLE);

    list.setOnItemClickListener(new OnItemClickListener() {

        public void onItemClick(AdapterView<?> list, View view, int position,
                long id) {
            Log.e("item clicked", String.valueOf(position));
        }
    });

    dialog.show();      
}