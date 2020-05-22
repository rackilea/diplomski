AutoCompleteTextView textView = (AutoCompleteTextView) findViewById(R.id.textfield);
String[] MyArray = getResources().getStringArray(R.array.myarray);
ArrayAdapter<String> adapter =
        new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, MyArray);
        textView.setThreshold(1);
        InputFilter[] filters = {
            new InputFilter.AllCaps(),
            new InputFilter.LengthFilter(40),};
    textView.setFilters(filters);
textView.setAdapter(adapter);