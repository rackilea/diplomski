public class MainActivity extends Activity  implements AdapterView.OnItemSelectedListener{

String[] items = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
boolean app_started = true;

@Override
public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main); 

    Spinner spinner1 = (Spinner) findViewById(R.id.spinner1);
    spinner1.setOnItemSelectedListener(this);

    ArrayAdapter AA = new ArrayAdapter(this, android.R.layout.simple_spinner_item, items);

    AA.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
    spinner1.setAdapter(AA);

}

    @Override
    public void onItemSelected(AdapterView parent, View view, int position, long id) {

        String selectedItem = parent.getItemAtPosition(position).toString();
  if(!app_started )
{


        if(selectedItem.equals("Item 1")) {         
            Toast.makeText(getApplicationContext(), "Item 1", Toast.LENGTH_LONG).show();
        }

        String selectedItem2 = parent.getItemAtPosition(position).toString();
        if(selectedItem.equals("Item 2")) {         
            Toast.makeText(getApplicationContext(), "Item 2", Toast.LENGTH_LONG).show();
        }

        String selectedItem3 = parent.getItemAtPosition(position).toString();
        if(selectedItem.equals("Item 3")) {         
            Toast.makeText(getApplicationContext(), "Item 3", Toast.LENGTH_LONG).show();
        }

        String selectedItem4 = parent.getItemAtPosition(position).toString();
        if(selectedItem.equals("Item 4")) {         
            Toast.makeText(getApplicationContext(), "Item 4", Toast.LENGTH_LONG).show();
        }

        String selectedItem5 = parent.getItemAtPosition(position).toString();
        if(selectedItem.equals("Item 5")) {         
            Toast.makeText(getApplicationContext(), "Item 5", Toast.LENGTH_LONG).show();
        }

 }
   app_started = false;

    }

    @Override
    public void onNothingSelected(AdapterView parent)  {


    }
}