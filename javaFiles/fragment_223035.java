public void removeFrag(int position) {
        removeTab(position);
        Log.e("REMOVING POSITION ",String.valueOf(position));
        Fragment fragment = mFragmentList.get(position);
        mFragmentList.remove(fragment);
        mFragmentTitleList.remove(position);
        Log.e("mFragmentList_REMOVE",String.valueOf(mFragmentList.size()));
        Log.e("TitleList_REMOVE",String.valueOf(mFragmentTitleList.size()));
        //destroyFragmentView(viewPager, position, fragment);
        notifyDataSetChanged();
        if (getCount() > 0) tabLayout.setupWithViewPager(viewPager);

        viewPager.setCurrentItem(getCount() - 1);
        setupTabLayout();
    }