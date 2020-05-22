// init variable
NumberPicker numberPicker1 = null;
NumberPicker numberPicker2 = null;

@Override
protected void onCreate(Bundle savedInstanceState) {

    setContentView(R.layout.activity_main);
 // After here only your Activity gets the layout objects

    numberPicker1 = (NumberPicker) findViewById(R.id.numberPicker1);
    numberPicker2 = (NumberPicker) findViewById(R.id.numberPicker2);

}