theSwtch = (Switch)findViewById(R.id.theSwtch);
    theSwtch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

            Double someNumber = Double.parseDouble(editTextInput.getText().toString());
            if (theSwtch.isChecked()){
                theSwtch.setText("Weekly"); 
                switcher = true;
                someNumber = someNumber/2;
                editTextInput.setText(someNumber.toString());
            } else if (!theSwtch.isChecked()) {
                theSwtch.setText("Bi-Weekly"); 
                switcher = false;
                someNumber = someNumber*2;
                editTextInput.setText(someNumber.toString());
            }
                // do something, the isChecked will be
               // true if the switch is in the On position
        }
    });