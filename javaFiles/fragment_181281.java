public void increaseClickCount() {
    int clickCount = sharedPrefs.getInt(NUMBER_OF_CLICKS, 0);
    clickCount++;
    SharedPreferences.Editor editor = sharedPrefs.edit();
    editor.putInt(NUMBER_OF_CLICKS, clickCount);
    editor.apply();
}