// Database 
    YourDatabaseClass db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.testgetdata);
        db = new YourDatabaseClass(getApplicationContext());
        List<TheModelClass> Anything = db.getValue();
        TheModelClass Value0 = Anything.get(0);
        TheModelClass Value1 = Anything.get(1);
        .
        .
        .
        TheModelClass ValueX = Anything.get(X*);

        String Value0 = Value0.getValue();

        //2nd column
        String Value1 = Value1.getValue();      

        //column X      
        String ValueX = ValueX.getValue();


        Intent person = new Intent(this, NameOfTheClassThatYouWantToHaveThisValues.class);
        Bundle backpack = new Bundle();

        backpack.putString("AKA_47", Value0);

        backpack.putString("Missile", Value1);
        .
        .
        .
        backpack.putString("Anything", ValueX);

        person.putExtras(backpack);
        setResult(RESULT_OK, person);
        startActivity(person);

            // Don't forget to close database connection
        db.closeDB();