buttonConvert.setOnClickListener(new OnClickListener() {

        @Override
        public void onClick(View arg0) {

            if(editCentimeters.getText().toString().equals("")){

                 editCentimeters.setError("*Field Required");

             }else{

            double centimeters = Double.valueOf( editCentimeters.getText().toString());

            double inches = centimeters *  0.393700787 ;

            editInches.setText(String.valueOf(inches));

           }

        }
    });