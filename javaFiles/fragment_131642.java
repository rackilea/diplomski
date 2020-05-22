public void putInt(String key, int num) 
    {
        SharedPreferences.Editor editor;
        editor = SP.edit();

        editor.remove("key");
        editor.putString("key", num);
        editor.commit(); // IF commit() showing warning then use apply() instead .
        editor.apply();

    }