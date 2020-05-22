FragmentPagerAdapter fragmentPagerAdapter = (FragmentPagerAdapter) viewPager.getAdapter();
    for(int i = 0; i < fragmentPagerAdapter.getCount(); i++) {
        ExamsListFragment viewPagerFragment = (ExamsListFragment) fragmentPagerAdapter.getItem(i);
        if(viewPagerFragment != null) {
            // Do something with your Fragment
            // Check viewPagerFragment.isResumed() if you intend on interacting with any views.
            if(viewPagerFragment.isResumed())
                viewPagerFragment.refreshExams(classType.getClassTypeId());
        }
    }