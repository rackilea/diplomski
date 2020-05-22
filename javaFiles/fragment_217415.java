public static List<User> getUser(Context context) {
    SharedPreferences preferences = context.getSharedPreferences(context.getString(R.string.preference_file_key), Context.MODE_PRIVATE);

    String userlist= preferences.getString("User","");
    Type collectionType = new TypeToken<List<User>>(){}.getType();
    userDetail = new Gson().fromJson(userlist, collectionType);
    return userDetail;
}