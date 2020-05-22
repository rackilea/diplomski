public class NewpActivity extends AppCompatActivity {
    String PaFirstName, PaLastName, PaDOB, PaGender, PaContact, PaStreetAPT, PaCity, PaState, country, PaPincode, PaInsurance;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        setContentView(R.layout.activity_newp);
        Button signUpBtn = (Button) findViewById(R.id.checkout_btn);
        try {
            DBOperator.copyDB(this);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("DB Copy Failed. Issuing runtime exception");
        }
        signUpBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Running method for updating string variables from input boxes
                //getValues();
                //DBOperator.getInstance().execSQL(SQLCommand.NEW_USER, getArgs());
                Toast.makeText(getBaseContext(), "Checkout successfully", Toast.LENGTH_SHORT).show();
            }
        });

        //<<<<<<<<<< ADDED TO CONFIRM DATABASE IS AS EXPECTED
        DBOperator checkit = DBOperator.getInstance();
        Cursor csr = checkit.execQuery("SELECT * FROM sqlite_master");
        while (csr.moveToNext()) {
            Log.d(
                    "DBINFO",
                    "Item with a name of " + csr.getString(csr.getColumnIndex("name")) +
                            " and a type of " + csr.getString(csr.getColumnIndex("type")) +
                            " found in the Database."
            );
        }
    }
}