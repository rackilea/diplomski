radioGroup = (RadioGroup) findViewById(R.id.radioGroup);
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                // checkedId is the RadioButton selected
                // get selected radio button from radioGroup
                int selectedId = radioGroup.getCheckedRadioButtonId();
                // find the radio button by returned id
                radioButton = (RadioButton) findViewById(selectedId);

                // toggle views on radio button click
                if (radioButton.getText().toString().equals("Activity A") {
                   startActivity(new Intent(CurrentActivity.this, ActivityA.class))
                } 
                else if (radioButton.getText().toString().equals("Activity B")) {
                    startActivity(new Intent(CurrentActivity.this, ActivityB.class))
                } 
                else if (radioButton.getText().toString().equals("Activity C")){
                    startActivity(new Intent(CurrentActivity.this, ActivityC.class))
                }
            }
        });