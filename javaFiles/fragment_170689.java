pager=(ViewPager)findViewById(R.id.pager);
pager.setAdapter(new SampleAdapter(getSupportFragmentManager()));
pager.setOnPageChangeListener(this);

@Override
public void onPageScrollStateChanged(int arg0) {
    // no code here
}

@Override
public void onPageScrolled(int arg0, float arg1, int arg2) {
    // no code here
}

@Override
public void onPageSelected(int position) {
    pagePosition = position;
}