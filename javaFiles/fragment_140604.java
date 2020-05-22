private void fnRadioTextSet(String strval) {
    RadioGroup rbtnGrp = (RadioGroup)findViewById(R.id.QueGroup1);
    String[] strArrtext = strval.split(",");
    for (int i = 0; i < rbtnGrp.getChildCount(); i++) {
        ((RadioButton) rbtnGrp.getChildAt(i)).setText(strArrtext[i]);
    }
}