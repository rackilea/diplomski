@Override
protected void onPause() {
    super.onPause();

    //create preferences and get editor, so that we can insert and save our array
    SharedPreferences preferences = getSharedPreferences(PREF_FILE, MODE_PRIVATE);
    SharedPreferences.Editor editor = preferences.edit();

    //convert ArrayList to set so that it can be stored
    //NOTE: putStringSet() was added in API 11
    Set<String> stringSet = new HashSet<String>(list);

    //place the set under the key 'mylist'
    editor.putStringSet("mylist", stringSet);

    //save it
    editor.commit();
}