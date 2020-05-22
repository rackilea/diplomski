@Override
public void onSaveInstanceState(@NonNull Bundle outState) {

    mFragmentManager.putFragment(outState, "dlf", mDaysListFragment);
    super.onSaveInstanceState(outState);
}