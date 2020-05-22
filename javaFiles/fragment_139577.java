Intent i;
Bundle extras;

String pname; 
int pcoins;
int pgems; 

@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

    i = getIntent();
    extras = i.getExtras();

    pname = extras.getString("P_NAME");
    pcoins = extras.getInt("P_COINS");
    pgems = extras.getInt("P_GEMS");

    // follow with your onCreate code ....
}