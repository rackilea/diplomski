static final int NUM_OF_BUTTONS=10;
List<Button> buttonsList = new ArrayList<>(NUM_OF_BUTTONS);
@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.test);

    for( int i=0 ;i<NUM_OF_BUTTONS;i++){
        String value = "btn"+(i+1);
        int id = getResources().getIdentifier(value,"id",getPackageName());
        buttonsList.add((Button) findViewById(id));
    }

}