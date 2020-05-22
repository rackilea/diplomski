public static void saveUser(Context context, User user) {
    SharedPreferences preferences = context.getSharedPreferences(context.getString(R.string.preference_file_key), Context.MODE_PRIVATE);
    SharedPreferences.Editor editor = preferences.edit();
    if (null == userDetail) {
        userDetail = new ArrayList<String>();
    }
    userDetail.add(user.toString());
    editor.putString("User", new Gson().toJson(userDetail));
    editor.commit();
}