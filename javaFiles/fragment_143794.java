viewPager.setOnPageChangeListener(new OnPageChangeListener() {

        ...

        @Override
        public void onPageSelected(int position) {
            // do what you want here, for example
            if (position != 3) {
                ...
            }
        }

});