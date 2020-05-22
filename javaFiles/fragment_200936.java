private static MyPrefListener myPrefListener = null;

private static class MyPrefListener implements Preference.OnPreferenceClickListener {

    private Context mContext;
    public MyPrefListener(Context context) {
        this.mContext = context;
    }

    @Override
    public boolean onPreferenceClick(Preference preference) {
        //USE mContext as the context object here
        return false;
    }
}