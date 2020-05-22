Class nextScreen = null;
if (pref1) {
  nextScreen = aActivity.class;
} else {
  nextScreen = bActivity.class;
}

if (nextScreen != null) {
    Intent goToNextActivity = new Intent(this, nextScreen);
}