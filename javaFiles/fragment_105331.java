@Override
protected void onResume() {
    super.onResume();

    SharedPreferences preferences = getSharedPreferences(PREF_FILE, MODE_PRIVATE);

    //get saved set, set to null if no set present
    Set<String> set = preferences.getStringSet("mylist", null);

    //if set is != null recreate ArrayList and assign to list variable
    //set will be null on first run, because onPause() have not yet been called
    //to save the array, hence we need to do this check 
    if (set != null) {
        list = new ArrayList<String>(set);
    }
}