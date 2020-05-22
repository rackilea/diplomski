@Override
protected void onCreate(@Nullable final Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    ....
    // Set a default color (if user is open you app for the first time)
    int chatColor = R.drawable.user_color1;

    // Add your logic to read the shared preference and convert that last color used to a valid drawable.
    // Like chatColor = pref.getInt(indexColorSelected, R.drawable.user_color1) etc....

    // Set the color in the adapter.
    chatAdapter = newAdapter(this, mChatDataList, chatColor);
}