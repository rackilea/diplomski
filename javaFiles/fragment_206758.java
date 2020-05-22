public class MainActivity extends Activity {
    /* You should get used to declaring everything with the correct visibility.  Good practice is to make everything private and use public mutator methods */
    //Global variable
    private double weight;
    private Button enter;  // creates a button 

    // Views
    private EditText wtEntry;
    private TextView txtForm2;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //Start with first screen
        setContentView(R.layout.activity_main);

        enter = (Button) findViewById(R.id.enterButton);

        //creates an editext and assigns the resource id of the xml edittext.
        wtEntry = (EditText)findViewById(R.id.inputwtEditText);
        txtForm2 = (TextView)findViewById(R.id.textViewform2);
    }
    // Button clicks shouldn't do anything but perform clicky actions. Leave field initialization, view creation, etc to the Activity.
    //buttonclick for form 1
    public void buttonclick(View view){
        //Receives the input from the edittext, converts it to a double (number).
        weight = Double.parseDouble(wtEntry.getText().toString());

        //change the value of the textview on screen 2 to the calculation value
       t2.setText(Double.toString(weight));

       // If you want a new layout, it's best to start a new activity.
       // It looks like you want to get information back, so use startActivityForResult().
       // setContentView(R.layout.planets);
       Intent dataIntent = new Intent(this, PlanetChooser.class);
       dataIntent.putExtra("com.yourpackage.identifier.DATA_WEIGHT", weight);
       startActivityForResult(dataIntent, Activity.RESULT_OK);
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        // Check that the resultCode is the same as we started the activity with
        if(resultCode == Activity.RESULT_OK){
            // get the double from the Intent, using the same string name (package prefixed)
            // or a default value if it didn't get set.
            double resultWeight = data.getDoubleExtra("com.yourpackage.identifier.RESULT_WEIGHT", 0.0);

            // Now do something with resultWeight
        }
    }
}
// PlanetChooser.class
public class PlanetChooser extends Activity {
    // constants, usually denoted by uppercase and declared static and final
    public static final double MERCURYFORCE = 0.38; 
    public static final double VENUSFORCE = 0.91; 
    public static final double EARTHFORCE = 1.00; 
    public static final double MARSFORCE = 0.38; 
    public static final double JUPITERFORCE = 2.34; 
    public static final double SATURNFORCE = 1.06; 
    public static final double URANUSFORCE = 0.92;
    public static final double NEPTUNEFORCE = 1.19;
    public static final double PLUTOFORCE = 0.06;

    private RadioButton mercury, venus, earth, mars, jupiter, saturn, uranus, neptune, pluto;

    // No need to use the Double object as opposed to the primitive unless you have good reason
    private double mercurypf, venuspf, earthpf, marspf, jupiterpf, saturnpf, uranuspf, neptunepf, plutopf, weight;

    // One variable will suffice, it seems.
    private double resultForce;

    public void onCreate(Bundle s){
        super.onCreate(s);
        setContentView(R.layout.planets);

        mercury = (RadioButton) findViewById(R.id.mercuryRadio);
        venus = (RadioButton) findViewById(R.id.venusRadio);
        earth = (RadioButton) findViewById(R.id.earthRadio);            
        mars = (RadioButton) findViewById(R.id.marsRadio);
        jupiter = (RadioButton) findViewById(R.id.jupiterRadio);
        saturn = (RadioButton) findViewById(R.id.saturnRadio);
        uranus = (RadioButton) findViewById(R.id.uranusRadio);
        neptune = (RadioButton) findViewById(R.id.neptuneRadio);
        pluto = (RadioButton) findViewById(R.id.plutoRadio);
    }
    public void buttonclick2(View view){
        /*
        It looks to me here you're looking to see which box is checked, and set a value based on 
        that planet.  Since instance variables (in this case mercurypf, jupiterpf, etc) are initialized
        to the default value (0), there's no need to set them manually.
        */

        // Code used to determine which planet RadioButton is checked:
        if(mercury.isChecked())    {
            resultForce = MERCURYFORCE * weight;
        }
        if(venus.isChecked()){
            resultForce = VENUSFORCE * weight;
        }
        if(earth.isChecked()){
            resultForce = EARTHFORCE * weight;
        }
        if(mars.isChecked()){
            resultForce = MARSFORCE * weight;
        }
        if(jupiter.isChecked()){
            resultForce =JUPITERFORCE * weight;
        }
        if(saturn.isChecked()){
            resultForce = SATURNFORCE * weight;
        }
        if(uranus.isChecked()){
            resultForce = URANUSFORCE * weight;
        }
        if(neptune.isChecked()){
            resultForce = NEPTUNEFORCE * weight;
        }
        if(pluto.isChecked()){
            resultForce = PLUTOFORCE * weight;
        }
        // Create a new data Intent to pass back to the calling activity, set the result code, 
        // and manually finish() this activity.
        Intent dataIntent = new Intent(this);
        dataIntent.putDoubleExtra("com.yourpackage.identifier.RESULT_DATA", resultForce);
        setResult(Activity.RESULT_OK, dataIntent);
        finish();
    }
}