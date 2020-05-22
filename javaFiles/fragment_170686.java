final HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
int pagePosition;

viewPager.setOnPageChangeListener(new OnPageChangeListener() {
    public void onPageScrollStateChanged(int state) {}
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {}

    public void onPageSelected(int position) {
        pagePosition = position;
    }
});

Button button= (Button) findViewById(R.id.buttonId);
button.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        map.put(pagePosition, buttonSelected);
    }
});