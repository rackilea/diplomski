public class MainActivity extends ActionBarActivity {

final int LENGTH = 5;

// Array of Objects
CustomObject[] customObjects = new CustomObject[LENGTH];


@Override
protected void onCreate(Bundle savedInstanceState) {

    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    // Creating the array
    customObjects[0] = new CustomObject("Object 0", false, false, true);
    customObjects[1] = new CustomObject("Object 1", true, false, true);
    customObjects[2] = new CustomObject("Object 2", true, false, true);
    customObjects[3] = new CustomObject("Object 3", false, false, true);
    customObjects[4] = new CustomObject("Object 4", true, false, true);

    int newLength = 0;
    for (int i = 0; i < LENGTH; i++) {
        if (customObjects[i].compareProperty("propertyOne")) {
            newLength++;
        }
    }
    CustomObject[] newCustomObjects = new CustomObject[newLength + 1];

    for (int i = 0, j = 0; i < LENGTH; i++) {
        if (customObjects[i].compareProperty("propertyOne")) {
            newCustomObjects[j] = customObjects[i];
            j++;
        }
    }
    newCustomObjects[newLength] = new CustomObject (" ", " ", true, true, true)

    //Adapter
    CustomListAdapter adapter = new CustomListAdapter(this, R.layout.list_layout, newCustomObjects);

    //Creating ListView
    ListView listViewItems = (ListView) findViewById(R.id.customList);
    listViewItems.setAdapter(adapter);

}

@Override
public boolean onCreateOptionsMenu(Menu menu) {


    // Inflate the menu; this adds items to the action bar if it is present.
    getMenuInflater().inflate(R.menu.main, menu);
    return true;
}

@Override
public boolean onOptionsItemSelected(MenuItem item) {
    // Handle action bar item clicks here. The action bar will
    // automatically handle clicks on the Home/Up button, so long
    // as you specify a parent activity in AndroidManifest.xml.
    int id = item.getItemId();
    if (id == R.id.action_settings) {
        return true;
    }
    return super.onOptionsItemSelected(item);
}

}