// Set to start with fragment
MapsFragment fragment = new MapsFragment();
android.support.v4.app.FragmentTransaction fragmentTransaction =
        getSupportFragmentManager().beginTransaction();
fragmentTransaction.replace(R.id.fragment_container, fragment);
fragmentTransaction.commit();