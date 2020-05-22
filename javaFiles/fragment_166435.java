// Restore preferences
    SharedPreferences settings = getSharedPreferences(PREF_FILE, Context.MODE_PRIVATE);
    Set<String> tempSet = settings.getStringSet(FIRST_LIST, "");
    Set<String> temp2Set = settings.getStringSet(SECOND_LIST, "");
    //if it is first time it will return null. So your app going crash. To avoid that make a default value. Like this.
    for (String str : tempSet)
        firstList.add(Uri.parse(str));
    for (String str : temp2Set)
        secondList.add(Uri.parse(str));