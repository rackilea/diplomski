yourSpinner.setOnItemSelectedListener(new OnItemSelectedListener() {

        @Override
        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

           switch(position) {
               case 0 : //calculate miles
               case 1 : //calculate kilometres
               .....
           }
        }

        @Override
        public void onNothingSelected(AdapterView<?> arg0) {

        }
    });