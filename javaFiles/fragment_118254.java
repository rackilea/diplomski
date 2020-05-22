public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.main);

    // Text view for selected country.
    selectedCountry = (TextView) findViewById(R.id.selected_country);

    textView.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
        public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
            selectedCountry.setText(adapterView.getItemAtPosition(i).toString());
        }
        public void onNothingSelected(AdapterView<?> adapterView) { }
    });
}