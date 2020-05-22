public void clickMethod(View v){
    RadioGroup group1 = (RadioGroup) findViewById(R.id.radioGroup1);
    int selected = group1.getCheckedRadioButtonId();
    RadioButton button1 = (RadioButton) findViewById(selected);
    if ("Right Answer".equals(button1.getText())) {
        Toast.makeText(this,"Correct!",Toast.LENGTH_SHORT).show();
    } else {
        Toast.makeText(this,"Incorrect.",Toast.LENGTH_SHORT).show();
    }
}