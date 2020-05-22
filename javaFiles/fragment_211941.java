if (fragment != null) {
            FragmentManager fragmentManager = getFragmentManager();
            fragmentManager.beginTransaction()
                .replace(R.id.frame_container, fragment).commit();

            // update selected item and title, then close the drawer
            mDrawerList.setItemChecked(position, true);
            mDrawerList.setSelection(position);
            setTitle(navMenuTitles[position]);
            mDrawerLayout.closeDrawer(mDrawerList);
} else if (listfragment != null) {
     FragmentManager fragmentManager = getFragmentManager();
     fragmentManager.beginTransaction()
         .replace(R.id.frame_container, listfragment).commit();
} else {
    // error in creating fragment
    Log.e("MainActivity", "Error in creating fragment");
}