@Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        Fragment mFragment = myPagerAdapter.getItem(mViewPager.getCurrentItem());
        if (fragment instanceof ServiccesFragment){
            ((ServiccesFragment)fragment).onActivityResult(requestCode, resultCode, data);
        }

    }