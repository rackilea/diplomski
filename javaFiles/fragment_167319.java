spinner_1.setOnItemSelectedListener(new OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> arg0, View arg1,
                    int position, long arg3) {

                            if(spinner_1.getSelectedItem().equals("Red")){
                            {
                                  // set adapter to spinner_2 here for "Red" selected
                            }
                            else
                            {
                                 // set adapter to spinner_2 for "Red" not selected
                            }
            }    
            @Override
            public void onNothingSelected(AdapterView<?> arg0) {                
            }
});