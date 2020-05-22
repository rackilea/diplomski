myButton.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        myButton.setVisibility(View.GONE);
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        SharedPreferences.Editor editor = preferences.edit();
        editor.putBoolean(SHARED_KEY_BUTTON_HIDE, true);
        editor.apply();
    }
});