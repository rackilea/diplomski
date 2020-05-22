Spinner.setOnItemSelectedListener(new OnItemSelectedListener() {

        public void onItemSelected(AdapterView<?> arg0, View arg1,
                int arg2, long arg3) {

                String selectedValue = arg0.getItemAtPosition(arg2).toString();

                if(selectedValue.equals("add")){
                          // add item to spinner
                }

        @Override
        public void onNothingSelected(AdapterView<?> arg0) {
            // TODO Auto-generated method stub

        }
    });