String stringToSave = "Save me!";

    // To save data to SP
    SharedPreferences.Editor editor = getContext().getSharedPreferences(SHARED_NAME_STRING, MODE_PRIVATE).edit();
    editor.putString(USER_NAME_STRING, stringToSave);
    editor.apply();

    // To load the data at a later time
    SharedPreferences prefs = getContext().getSharedPreferences(SHARED_NAME_STRING, MODE_PRIVATE);
    String loadedString = prefs.getString(USER_NAME_STRING, null);