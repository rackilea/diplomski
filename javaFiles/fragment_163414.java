protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    if (savedInstanceState == null) {
        getSupportFragmentManager().beginTransaction()
                .add(R.id.container, new PlaceholderFragment())
                .commit();
    }
spinner = (Spinner)findViewById(R.id.spinner1);
ageSpinner();
ArrayAdapter<Integer> spinnerAdapter = new ArrayAdapter<Integer>(this,             android.R.layout.simple_spinner_item, list);
spinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
spinner.setAdapter(spinnerAdapter);
}
 private void ageSpinner(){

    list = new ArrayList<Integer>();
    for(int i=0; i<=4; i++){
        list.add(i);


    }