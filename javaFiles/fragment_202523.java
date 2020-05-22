private void selectItem(int position) {
    FragmentManager fragmentManager = getSupportFragmentManager();
    FragmentTransaction ft = fragmentManager.beginTransaction();


    switch (position) {

    case 0:

        ft.replace(R.id.content_frame, new Fragment1, Constants.TAG_FRAGMENT).commit();

        break;


    case 1:
        ft.replace(R.id.content_frame, new Fragment2, Constants.TAG_FRAGMENT);

        ft.commit();
        break;

    }

    mDrawerList.setItemChecked(position, true);
    setTitle(title[position]);

    // Close drawer
    mDrawerLayout.closeDrawer(mDrawerList);
}