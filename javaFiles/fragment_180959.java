@Override
public void switchFragment(@Nullable android.app.Fragment targetFragment, @Nullable boolean addToBackStack, Bundle bundle, @Nullable String fragmentTag) {
    android.app.FragmentManager fragmentManager = getFragmentManager();
    android.app.FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
    if (addToBackStack) {
        fragmentTransaction.addToBackStack(fragmentTag);
    }
    if (bundle != null) {
        targetFragment.setArguments(bundle);
    }
    fragmentTransaction.setCustomAnimations(R.anim.enter_from_right, R.anim.exit_to_left, R.anim.enter_from_left, R.anim.exit_to_right);
    fragmentTransaction.replace(R.id.container, targetFragment);
    fragmentTransaction.commit();

}