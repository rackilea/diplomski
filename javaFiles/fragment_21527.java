// For AppCompat use getSupportFragmentManager
Fragment fragment = new DefaultFragment();
FragmentManager fragmentManager = getFragmentManager();

if (selectedPane == R.id.buttonOne) {
    fragment = new ButtonOneFragment();
} else if (selectedPane == R.id.buttonTwo) {
    fragment = new ButtonTwoFragment();
} else if (selectedPane == R.id.buttonThree) {
    fragment = new ButtonThreeFragment();
}

fragmentManager.beginTransaction()
                .replace(R.id.container, fragment)
                .commit();