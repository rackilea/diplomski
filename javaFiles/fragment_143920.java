public class MainActivity extends AppCompatActivity {

    EditText item;
    EditText quantity;
    TextView calories;
    Button calculate;

    dietclass dbhelper; //<<<< we want an instance of the database helper
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_foodcal);

        item = (EditText)findViewById(R.id.etitem);
        quantity = (EditText)findViewById(R.id.etquantity);
        calories = (TextView)findViewById(R.id.calories);
        calculate = (Button)findViewById(R.id.calculate);

        dbhelper = new dietclass(this); //<<<< get the instance of the database helper

        dbhelper.insertCal_ValEntry("Porridge", "100g",5000); //<<<< For testing 
        dbhelper.insertCal_ValEntry("Cake","500g", 20000); //<<<< For testing


        calculate.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                String itemstr = item.getText().toString();
                printDatabase(itemstr);

                //String dbstring = dietclass.databaseToString(itemstr);
                //calories.setText(String.valueOf(dbstring));
            }
        });
    }

    public void printDatabase(String item){
        String dbstring =  dbhelper.databaseToString(item); //<<<< 
        //String label;wr
        //label = dbstring + "calories";
        calories.setText(String.valueOf(dbstring));
    }
}