@Override
protected void onCreate(Bundle savedInstanceState) 
{
    super.onCreate(savedInstanceState);
    setContentView(R.layout.main2);

    totalcostEdit = (EditText) findViewById (R.id.totaltripcostseditText);
    totallodgingEdit = (EditText) findViewById (R.id.totallodgingcostseditText);

    updateStandard();

}

private void updateStandard()
{

    //Calculate total lodging costs
    double totallodging = 2;

    totallodgingEdit.setText(String.valueOf(totallodging));

}