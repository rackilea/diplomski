DetailActivityFragment fragment = new DetailActivityFragment();
if (fragment != null) {
    FragmentManager fragmentManager = getFragmentManager();
    fragmentManager.beginTransaction()
            .replace(R.id.frame_container, fragment).commit();
} else {
    // error in creating fragment
    Log.e(LOG_TAG, "Error in creating fragment");
}