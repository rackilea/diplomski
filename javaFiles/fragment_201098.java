@Override
protected void onPause() {
    super.onPause();

    SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
    Editor editor = prefs.edit();
    editor.putString("ButtonText", ((TextView)findViewById(R.id.buttonText)).getText().toString());
    editor.commit();
}