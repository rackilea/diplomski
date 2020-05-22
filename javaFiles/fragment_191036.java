public void saveState(YourState state) {
    SharedPreferences sharedPreferences = app.getSharedPreferences(R.string.preference_file_key, Context.MODE_PRIVATE)
    sharedPreferences.edit()
        .putString("CustomAtt", state.getCustomAtt())
}

public YourState loadState() {
    SharedPreferences sharedPreferences = app.getSharedPreferences(R.string.preference_file_key, Context.MODE_PRIVATE)
    String customAtt = sharedPreferences.getString("CustomAtt", "DefaultValue")
    return new YoutState(customAtt)
}