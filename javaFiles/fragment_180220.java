@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.testgetdata);

        db = new YourDatabaseClass(getApplicationContext());

        List<TheModelClass> Anything = db.getAllDataOfTheList();

        TheModelClass Value0 = Anything.get(0);
        TheModelClass Value1 = Anything.get(1);
        .
        .
        .
        TheModelClass ValueX = Anything.get(X*);
        /*Based on how many row you have, Start with row 0 (zero)
         * whenever TheModelClass Value0 = Anything.get(0); called then you will have
         * column0Value0 column01alue1 column2Value2.........columnXValueX      
         */
         long Value0FromColumn0 = Value0.getId();
        String Value1FromColumn0 = Value0.getName();
        int Value2FromColumn0 = Value0.getPhoneNumber();
        double Value3FromColumn0 = Value0.getETC();

        //2nd column
        long Value0FromColumn1 = Value1.getId();
        String Value1FromColumn1 = Value1.getName();
        int Value2FromColumn1 = Value1.getPhoneNumber();
        double Value3FromColumn1 = Value1.getETC();

        //column X
        long ValueXFromColumnX = ValueX.getId();
        String ValueXFromColumnX = ValueX.getName();
        int ValueXFromColumnX = ValueX.getPhoneNumber();
        double ValueXFromColumnX = ValueX.getETC();

        Intent person = new Intent(this, NameOfTheClassThatYouWantToHaveThisValues.class);
        Bundle backpack = new Bundle();
        backpack.putLong("Pencil", Value0FromColumn0);
        backpack.putString("Book", Value1FromColumn0);
        backpack.putInt("Laptop", Value2FromColumn);
        backpack.putDouble("Nuclear_BOMB", Value3FromColumn0);

        backpack.putLong("Spiderman", Value0FromColumn1);
        backpack.putString("IronMan", Value1FromColumn1);
        backpack.putInt("Hercules", Value2FromColumn1);
        backpack.putDouble("MasterYoda", Value3FromColumn1);
        .
        .
        .
        backpack.putLong("Monkey", ValueXFromColumnX);
        backpack.putString("Dolphin", ValueXFromColumnX);
        backpack.putInt("Alien", ValueXFromColumnX);
        backpack.putDouble("Predator", ValueXFromColumnX);

        person.putExtras(backpack);
        setResult(RESULT_OK, person);
        startActivity(person);

        // Don't forget to close database connection
        db.closeDB();