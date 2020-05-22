final String[] arrayEmpty = {""};
final EditText State = (EditText)findViewById(R.id.EditState);
State.setOnFocusChangeListener(new View.OnFocusChangeListener() {
    @Override
    public void onFocusChange(View v, boolean hasFocus) {
        if (!hasFocus) {
            listCities newClassObj = new listCities();
            AutoCompleteTextView autoCompleteTextView;
            ArrayAdapter<String> arrayAdapter;
            String [] Cities;

            if(State.getText().toString().equalsIgnoreCase("Kerala")) {
                Cities = newClassObj.list_Kerala();
                autoCompleteTextView = (AutoCompleteTextView) findViewById(R.id.EditCities);
                arrayAdapter = new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_list_item_1, Cities);
            }
            else if(State.getText().toString().equalsIgnoreCase("Deli")) {
                Cities = newClassObj.list_Deli();
                autoCompleteTextView = (AutoCompleteTextView) findViewById(R.id.EditCities);
                arrayAdapter = new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_list_item_1, Cities);
            }
            else { //Last Else clear the array
                autoCompleteTextView = (AutoCompleteTextView) findViewById(R.id.EditBairro);
                arrayAdapter = new ArrayAdapter<String>(DenunciaActivity.this, android.R.layout.simple_list_item_1, arrayEmpty);
            }

            autoCompleteTextView.setAdapter(arrayAdapter);
            autoCompleteTextView.setThreshold(2);
        }
    }
});