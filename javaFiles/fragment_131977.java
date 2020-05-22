public class TabListenerImpl implements ActionBar.TabListener {

    private List<TabInfo> mTabs = new ArrayList<TabInfo>();
    private Context mContext;

    public TabListenerImpl(Context context) {
        mContext = context;
    }

    @Override
    public void onTabReselected(Tab tab, FragmentTransaction ft) {

    }

    @Override
    public void onTabSelected(Tab tab, FragmentTransaction ft) {
        // iterate over all of the tabs, match the tag we have and see if
        // we also have a fragment instance for it. If we don't, create one
        // and add it to the container, if we have an instance simply attach
        // it. Detach every other tag which doesn't match the tag.
        for (TabInfo t : mTabs) {
            if (tab.getTag() == t.tag) {
                if (t.pageFragment == null) {
                    t.pageFragment = Fragment.instantiate(mContext,
                            t.clazz.getName());
                    ft.add(android.R.id.content, t.pageFragment, t.tag);
                } else {
                    ft.attach(t.pageFragment);
                }
            } else {
                if (t.pageFragment != null && !t.pageFragment.isDetached()) {
                    ft.detach(t.pageFragment);
                }
            }
        }
    }

    @Override
    public void onTabUnselected(Tab tab, FragmentTransaction ft) {
        // faulty method
    }

    /**
     * Call this method BEFORE you call the actionBar.addTab() method!
     * 
     * @param tag
     *            a String representing the tag that was set on the tab to
     *            identify itself
     * @param clazz
     *            the class of the Fragment
     */
    public void addTab(String tag, Class<? extends Fragment> clazz) {
        TabInfo ti = new TabInfo();
        ti.clazz = clazz;
        ti.tag = tag;
        mTabs.add(ti);
    }

    // wrapper class
    private class TabInfo {
        Class<? extends Fragment> clazz;
        Fragment pageFragment;
        String tag;
    }

}