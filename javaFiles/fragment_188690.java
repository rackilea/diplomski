// in the constants section
private static final String DISPLAY_FORMAT_STR = "%02d:%02d:%02d:%01d";   


private void showTimeLeft() {
  int oldMin = min;
  hours = (int) (deltaTime / (MS_PER_SEC * SEC_PER_MIN * MIN_PER_HR));
  min = (int) (deltaTime / (MS_PER_SEC * SEC_PER_MIN) % MIN_PER_HR);
  sec = (int) (deltaTime / (MS_PER_SEC) % SEC_PER_MIN);
  msec = (int) (deltaTime % MS_PER_SEC);

  String displayString = String.format(DISPLAY_FORMAT_STR, hours, min, sec,
        msec / 100);
  displayField.setText(displayString);

  // ... etc...