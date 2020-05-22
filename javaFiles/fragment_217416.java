public static User getUser(Context context, String id) throws NoUserException {
    SharedPreferences preferences = context.getSharedPreferences(context.getString(R.string.preference_file_key), Context.MODE_PRIVATE);

    String userlist= preferences.getString("User","");
    Type collectionType = new TypeToken<List<User>>(){}.getType();
    userDetail = new Gson().fromJson(userlist, collectionType);
    for (User user : userDetail) {
        if(user.getID().equals(id)){
            return user;
        }
    }
    return null;
}