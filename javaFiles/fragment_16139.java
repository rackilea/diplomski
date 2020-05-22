RadioGroup rgp = (RadioGroup) findViewById(R.id.radiogroup);
RadioGroup.LayoutParams rprms;

for(int i = 0; i < 3; i++) {
  RadioButton radioButton = new RadioButton(this);
  radioButton.setText("new" + i);
  radioButton.setId("rbtn" + i);
  rprms = new RadioGroup.LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
  rgp.addView(radioButton, rprms);
}