greenCheckBox.setChecked(false);
yellowCheckBox.setChecked(false);
redCheckBox.setChecked(false);
showAllCards();


greenCheckBox.setOnCheckedChangeListener(new OnCheckedChangeListener() {
  @Override
  public void onCheckedChanged(CompoundButton button, boolean isChecked) {
    if (isChecked){
      yellowCheckBox.setChecked(false);
      redCheckBox.setChecked(false);
      showGreenCards();
    }else {
      showAllCards();
    }
  }
});


yellowCheckBox.setOnCheckedChangeListener(new OnCheckedChangeListener() {
  @Override
  public void onCheckedChanged(CompoundButton button, boolean isChecked) {
    if (isChecked){
      greenCheckBox.setChecked(false);
      redCheckBox.setChecked(false);
      showYellowCards();
    }else {
      showAllCards();
    }
  }
});

redCheckBox.setOnCheckedChangeListener(new OnCheckedChangeListener() {
  @Override
  public void onCheckedChanged(CompoundButton button, boolean isChecked) {
    if (isChecked){
      yellowCheckBox.setChecked(false);
      greenCheckBox.setChecked(false);
      showRedCards();
    }else {
      showAllCards();
    }
  }
});