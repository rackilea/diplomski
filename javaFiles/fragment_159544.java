SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
boolean hideButton = preferences.getBoolean(SHARED_KEY_BUTTON_HIDE, false);

if(hideButton) {
    myButton.setVisibility(View.GONE);
}