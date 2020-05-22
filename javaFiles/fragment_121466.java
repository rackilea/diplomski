private static final int TYPE_LOCATION=0;
    private static final int TYPE_INFO=1;
    private static final int TYPE_COMMENT=2;

tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                switch (tab.getPosition()) {
                    case 0:
                        LoadFragment(TYPE_LOCATION);
                        break;
                    case 1:
                        LoadFragment(TYPE_INFO);
                        break;
                    case 2:
                        LoadFragment(TYPE_COMMENT);
                        break;
                }
            }

private void LoadFragment(int typeOfFragment) {
        Log.i("MainActivity", "inside load fragment");
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();

        switch (typeOfFragment) {

            case TYPE_LOCATION:   
              ft.replace(R.id.coordinate_layout, new LocationFragment());
                break;


            case TYPE_INFO:
                ft.replace(R.id.coordinate_layout, new InformationFragment());
                break;


            case TYPE_COMMENT:
                ft.replace(R.id.coordinate_layout, new CommentsFragment());
                break;

            ft.commit();

        }
    }