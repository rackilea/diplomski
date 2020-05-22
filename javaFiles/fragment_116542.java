@Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.navigation_home:
                // hide about
                aboutInfo.setVisibility(View.INVISIBLE);
                return true;
            case R.id.navigation_about:
                // show about
                aboutInfo.setVisibility(View.VISIBLE);
                return true;
        }
        return false;
    }