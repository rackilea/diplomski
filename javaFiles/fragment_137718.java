public static WelcomeFragment newInstance(String title, int layoutID, int titleID) {

    WelcomeFragment mWelcomeFragment = new WelcomeFragment();

    mTitle = title;
    mLayoutID = layoutID;
    mTitleID = titleID;

    return mWelcomeFragment;
}