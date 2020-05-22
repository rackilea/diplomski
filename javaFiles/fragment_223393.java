@Override
    public void onBackPressed() {
        if (getFragmentManager().getBackStackEntryCount() > 0) {
            showAlertDialog(Constants.EXIT_APP, Constants.APP_NAME);
        } else {
            getFragmentManager().popBackStackImmediate();
        }
    }