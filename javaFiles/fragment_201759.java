public Map<String, String> getData(Context context) { //other paramaters are only usefull if you want provide default values
    SharedPreferences sharedPrefs = PreferenceManager.getDefaultSharedPreferences(context);
    Map<String, String> userDetails = new HashMap<String,String>(); //create the map with String->String

    String name = sharedPrefs.getString(NAME_KEY, null); //get the value
    userDetails.put(NAME_KEY, name); //put it in the map
    String username = sharedPrefs.getString(USERNAME_KEY, null);
    userDetails.put(USERNAME_KEY, username);
    String dob = sharedPrefs.getString(DOB_KEY, null);
    userDetails.put(DOB_KEY, dob);

    return userDetails; //return the map
}