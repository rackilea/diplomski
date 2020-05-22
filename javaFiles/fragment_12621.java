private String prefName = "preferences";


/**
* Save the arraylist of Strings in a preferences file.
*/
public void saveArray(Context context, ArrayList<String> myArray) {
    SharedPreferences sharedPref = context.getSharedPreferences(prefName,Context.MODE_PRIVATE);
    Editor editor = sharedPref.edit();

    for (int i = 0; i < myArray.size(); i++) {
        editor.putString(String.valueOf(i), myArray.get(i));
    }

    editor.commit();
}

/**
* Reads the saved contents in order.
*/
public ArrayList<String> readArray(Context context) {
    SharedPreferences sharedPref = context.getSharedPreferences(prefName,Context.MODE_PRIVATE);
    Editor editor = sharedPref.edit();

    int size = sharedPref.getAll().size();
    ArrayList<String> ret = new ArrayList<>();

    for (int i = 0; i < myArray.size(); i++) {
        ret.add(i,sharedPref.getString(String.valueOf(i)));
    }

    return ret;
}