public class main extends Activity {
/** Called when the activity is first created. */

ListView lstTest;
//Array Adapter that will hold our ArrayList and display the items on the ListView
JSONAdapter jSONAdapter ;


@Override
public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.main);
    //Initialize ListView
    lstTest= (ListView)findViewById(R.id.lstText);


    jSONAdapter = new JSONAdapter (main.this,jArray);//jArray is your json array 

    //Set the above adapter as the adapter of choice for our list
    lstTest.setAdapter(jSONAdapter );


}