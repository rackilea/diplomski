RadioGroup radioGroup = (RadioGroup) findViewById(R.id.yourRadioGroup);        
    radioGroup.setOnCheckedChangeListener(new OnCheckedChangeListener() 
    {
        @Override
        public void onCheckedChanged(RadioGroup group, int checkedId) {
            // checkedId is the RadioButton selected
        }
    });