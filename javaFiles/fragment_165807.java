public void moveToNextPage(View view) {
    //it doesn't matter if you're already in the last item
    viewPager.setCurrentItem(viewPager.getCurrentItem() + 1);
}

public void moveToPreviousPage(View view) {
    //it doesn't matter if you're already in the first item
    viewPager.setCurrentItem(viewPager.getCurrentItem() - 1);
}