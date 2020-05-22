@Override
public void onPageSelected(int position) {
    if(!isAdded ())
         return;

    for (int i = 0; i < dotsCount; i++) {
        dots[i].setImageDrawable(getResources().getDrawable(R.drawable.nonselecteditem_dot));
    }
    if (position >= dotsCount) {
        dots[0].setImageDrawable(getResources().getDrawable(R.drawable.selecteditem_dot));
    } else {
        dots[position].setImageDrawable(getResources().getDrawable(R.drawable.selecteditem_dot));
    }
}