Public class yourclassname extends Activity implements OnClickListener {

Text View airportCodeText1, airportCodeText2, airporttext1, airporttext2, departureTime, arrivalTime, flightNumberText, desk, gate, flightNumberTitle, deskTitle, gateTitle;



@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.fragment_main);
        Initializer();
       }

 private void initializer() {
        airportCodeText1 = (TextView) findViewById(R.id.airportCode1);
        //Repeat for each TextView 
        //I didnt wanna do the whole code for you.

       }