//First in the NavigationDrawerFragment class that is created with the
//Drawer template I added two methods, that will adjust the drawer's view
//change action bar to show up caret
    public static void showSubActionBar() {
        mDrawerToggle.setDrawerIndicatorEnabled(false);
    }
    //change action bar to show navigation drawer icon
    public static void showNavActionBar() {
        mDrawerToggle.setDrawerIndicatorEnabled(true);
    }

//Then in my MainActivity class I add a small method that uses a counter
// to determine if a user is in a sub level (since some 
//fragments may have up to 4 sub levels) or back on the main view 
//and updates the ActionBar
public void subLevelCounter(int counter) {

       levelCounter = levelCounter + counter;
        if (levelCounter > 0) {
            NavigationDrawerFragment.showSubActionBar();
        }
        else {
            NavigationDrawerFragment.showNavActionBar();

        }
        invalidateOptionsMenu();

    }

//So now when the back button is visible and pressed I updated the counter
//and call the onBackPressed method
if (item.getItemId() == android.R.id.home) {
            ((MainActivity) getActivity()).subLevelCounter(-1);
            getActivity().onBackPressed();
            return true;
        }

//And when I'm drilling down I just add this line before calling the 
//backlist method to perform the navigation
                ((MainActivity) thisActivity).subLevelCounter(1);