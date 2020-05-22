final Handler handler = new Handler();
final Runnable Update = new Runnable() {
    public void run() {
        int currentPage = mPager.getCurrentItem();
        if (currentPage == NUM_PAGES-1) {
            currentPage = 0;
        } else {
            currentPage++;
        }
        mPager.setCurrentItem(currentPage, true);

        handler.postDelayed(this, 5000);
    }
};

handler.postDelayed(Update, 500);