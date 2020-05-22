private BroadcastReceiver mLangReceiver = null;

protected BroadcastReceiver setupLangReceiver(){

    if(mLangReceiver == null) {

        mLangReceiver = new BroadcastReceiver() {

            @Override
            public void onReceive(Context context, Intent intent) {
                // do what you want
            }

        };

        registerReceiver(mLangReceiver, new IntentFilter(Intent.ACTION_LOCALE_CHANGED));
    }

    return mLangReceiver;
}