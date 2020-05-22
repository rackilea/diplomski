@Override
public void onBackPressed() {
    MenuItem homeItem = mBottomNav.getMenu().getItem(0);

    if (mSelectedItem != homeItem.getItemId()) {

        selectFragment(homeItem);

        // Select home item
        mBottomNav.setSelectedItemId(homeItem.getItemId());
    } else {
        super.onBackPressed();
    }
}