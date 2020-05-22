private void initview1() {

    RadioButton filtersearch = (RadioButton) findViewById(R.id.filtersearch);
    RadioButton traceme = (RadioButton) findViewById(R.id.traceme);
    Button Search_Buttom = (Button) findViewById(R.id.Search_Buttom);
    EditText mainSearch = (EditText) findViewById(R.id.mainSearch);

    Search_Buttom.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            Boolean fsVr = false, tmVr = false;
            String search_data = mainSearch.getText().toString();
            fsVr = filtersearch.isChecked();
            tmVr = traceme.isChecked();
// go to your new activity with required data..
        }
    });
}