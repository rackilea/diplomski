@Override
    public void onBackPressed() {
        if(mBottomNavigationView.getSelectedItemId () != R.id.ic_home)
        {
            mBottomNavigationView.setSelectedItemId(R.id.ic_home);
        }
        else
        {
            super.onBackPressed();
        }     
    }