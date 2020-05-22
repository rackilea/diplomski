protected void onResume() {
    super.onResume();
        getPrefs();

    //...Now update your objects with preference values         
}

private void getPrefs() {
    SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
    String myPref = prefs.getString("myPref", "");
}