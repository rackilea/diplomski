public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

    SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(getActivity());
    mUserLearnedDrawer = sp.getBoolean(PREF_USER_LEARNED_DRAWER, false);

    if (savedInstanceState != null) {
        mCurrentSelectedPosition = savedInstanceState.getInt(STATE_SELECTED_POSITION);
        mFromSavedInstanceState = true;
    }

    // Select either the default item (0) or the last selected item, i.e. selectItem(mCurrentSelectedPosition);
    if (activity_main.webview != null) {
        selectItem(0);
    }
}