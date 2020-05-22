Spinner spinCountry;
spinCountry= (Spinner) findViewById(R.id.spinCountry);//fetch the spinner from layout file
ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
            android.R.layout.simple_spinner_item, getResources()
                    .getStringArray(R.array.country_array));//setting the country_array to spinner
adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
    spinCountry.setAdapter(adapter);
//if you want to set any action you can do in this listener
spinCountry.setOnItemSelectedListener(new OnItemSelectedListener() {
        @Override
        public void onItemSelected(AdapterView<?> arg0, View arg1,
                int position, long id) {
                  SavePreferences("LIST",spinCountry.getSelectedItem().toString());
        }

        @Override
        public void onNothingSelected(AdapterView<?> arg0) {
        }
    });