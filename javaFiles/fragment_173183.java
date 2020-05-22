public void goToMain(View v) {
    FragmentTransaction transaction = getFragmentManager().beginTransaction();
    transaction.replace(R.id.container, mainFragment);
    transaction.addToBackStack(null);
    transaction.commit();
}