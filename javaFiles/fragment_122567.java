@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_default);
    ...
    ...
    displayValues();
    ...
    ...
}

private void displayValues(){
    Cursor res = myDb.getAllData();

    if(res.getCount() == 0) {
    // Show message
    showMessage("Error", "No data found");
    return;
    }

    StringBuffer buffer = new StringBuffer();
    int total = 0;
    // assuming here that you only have to add the Amount values    
    while (res.moveToNext()) {
    //hear you can initilize variables or arrays with the other values from your db which you want to use further.
    total +=res.getInt(1);//addind up all the values of Amount column
    }

    yourEditText.setText(""+total);
}