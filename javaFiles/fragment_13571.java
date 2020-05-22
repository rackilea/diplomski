RadioGroup modechoice = (RadioGroup) findViewById(R.id.modeselection);
RadioGroup sizechoice = (RadioGroup) findViewById(R.id.textsizeselection);

int modeChoiceId = modechoice.getCheckedRadioButtonId();
int sizeChoiceId = sizechoice.getCheckedRadioButtonId();

// An example, not sure about your logic.
if (modeChoiceId == R.id.textmode && sizeChoiceId == R.id.normal){

}