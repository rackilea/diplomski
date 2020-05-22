radioGroup1.setOnCheckedChangeListener(new OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(RadioGroup group, int checkedId) { 
            RadioButton radioButton = (RadioButton) findViewById(checkedId);
            //other logic here (like what do you want to do with this selected RadioButton)
        }
});