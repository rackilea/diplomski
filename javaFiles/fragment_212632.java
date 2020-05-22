private void updateDisplay() {
    String timeSet = new StringBuilder()
            .append(pad(pHour)).append(":")
            .append(pad(pMinute)).toString();

    mTimeView.setText(timeSet);

    SharedPreferences sharedPref = RemindersActivity.this.getPreferences(Context.MODE_PRIVATE);
    SharedPreferences.Editor prefEditor = sharedPref.edit();
    sharedPref.putString("timeSet", timeSet);
    sharedPref.commit();
}