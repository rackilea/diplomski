public void clear(ViewGroup container){
    if (mCurTransaction == null) {
        mCurTransaction = mFragmentManager.beginTransaction();
    }

    for(int i = 0; i < getCount(); i++){

        final long itemId = getItemId(i);

        // Do we already have this fragment?
        String name = "android:switcher:" + container.getId() + ":" + itemId;
        Fragment fragment = mFragmentManager.findFragmentByTag(name);

        if(fragment != null){
            mCurTransaction.detach(fragment);
        }
    }
    mCurTransaction.commitAllowingStateLoss();
    mCurTransaction = null;
}