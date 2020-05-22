final ArrayList<String> arrayList = new ArrayList<>();
    arrayList.add("Menu1");
    arrayList.add("Menu2");
    arrayList.add("Menu3");
    arrayList.add("Menu4");
viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {

        @Override
        public void onPageSelected(int position) {
            getSupportActionBar().setTitle(arrayList.get(position));
        }

        @Override
        public void onPageScrolled(int arg0, float arg1, int arg2) {
            // TODO Auto-generated method stub

        }

        @Override
        public void onPageScrollStateChanged(int pos) {
            // TODO Auto-generated method stub

        }
    });