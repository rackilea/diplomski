tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
    @Override
    public void onTabSelected(TabLayout.Tab tab) {
        tab.setIcon(R.drawable.newicon);
         //also you can use tab.setCustomView() too
    }

    @Override
    public void onTabUnselected(TabLayout.Tab tab) {
        tab.setIcon(R.drawable.oldicon);
    }

    @Override
    public void onTabReselected(TabLayout.Tab tab) {

    }
});