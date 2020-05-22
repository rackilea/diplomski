// load list from preference
        SharedPreferences prefs = getSharedPreferences(SHARED_PREFS_FILE, Context.MODE_PRIVATE);
        ArrayList<String> strings = new ArrayList<String>();
        try {
            strings = (ArrayList<String>) ObjectSerializer.deserialize(prefs.getString("LIST", ObjectSerializer.serialize(new ArrayList<String>())));
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }