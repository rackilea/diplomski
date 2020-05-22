final Spinner spinnerBackgroundChange = (Spinner)findViewById(R.id.spinner1);
        spinnerBackgroundChange.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                SharedPreferences sharedPref = getSharedPreferences("My_Prefs", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor=sharedPref.edit();
                editor.putInt("spinnerValue", spinnerBackgroundChange.getSelectedItemPosition());
                editor.apply();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });