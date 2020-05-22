@Override
public void onBackPressed() {
    super.onBackPressed();
    SharedPreferences.Editor editor = preferences.edit();
        editor.putInt("balance", balance);
        editor.apply();
}