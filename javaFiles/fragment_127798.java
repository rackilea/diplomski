private void addCoins(int amount) {
    coinCount += amount;
    mText.setText(" " + coinCount);

    SharedPreferences sharedpreferences = getSharedPreferences(PREFS_NAME,0);
    SharedPreferences.Editor editor = sharedpreferences.edit();
    editor.putInt("coins", coinCount);
    editor.apply();
}