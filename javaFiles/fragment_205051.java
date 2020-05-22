ArrayList<String> strings = new ArrayList<String>();
    string.add("Hello!");
    //save list into SP
    SharedPreferences prefs = getSharedPreferences(SHARED_PREFS_FILE, Context.MODE_PRIVATE);
    Editor editor = prefs.edit();
    try {
        editor.putString("LIST", ObjectSerializer.serialize(strings));
    } catch (IOException e) {
        e.printStackTrace();
    }
    editor.commit();