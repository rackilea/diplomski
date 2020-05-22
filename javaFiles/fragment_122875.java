citySpinner.setOnItemSelectedListener(new Spinner.OnItemSelectedListener() {
        @Override
        public void onItemSelected(Spinner parent, View view, int position, long id) {
            selectedCity = citySpinner.getSelectedItem().toString(); // <--
            updateTheatersSpinner(selectedCity);
            mSettings.edit().putString("selectedCity", selectedCity).commit();
        }
    });

    theaterSpinner.setOnItemSelectedListener(new Spinner.OnItemSelectedListener() {
        @Override
        public void onItemSelected(Spinner parent, View view, int position, long id) {
            selectedTheater = theaterSpinner.getSelectedItem().toString(); // <--
            mSettings.edit().putString("selectedTheater", selectedTheater).commit();
        }
    });