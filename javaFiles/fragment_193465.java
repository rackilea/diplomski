public void onRadioButtonClicked(View view) {
    // Is the button now checked?
    boolean checked = ((RadioButton) view).isChecked();

    // Check which radio button was clicked
    switch(view.getId()) {
        case R.id.maleButton:
            if (checked)
                hashMap.put("male", true);
            break;
        case R.id.femaleButton:
            if (checked)
                hashMap.put("male", false);
            break;
    }
}