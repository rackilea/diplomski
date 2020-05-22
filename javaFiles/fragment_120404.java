public void startPreferencePanel(String fragmentClass, Bundle args, @StringRes int titleRes,
        CharSequence titleText, Fragment resultTo, int resultRequestCode) {
    Fragment f = Fragment.instantiate(this, fragmentClass, args);
    if (resultTo != null) {
        f.setTargetFragment(resultTo, resultRequestCode);
    }
    FragmentTransaction transaction = getFragmentManager().beginTransaction();
    transaction.replace(com.android.internal.R.id.prefs, f);
    if (titleRes != 0) {
        transaction.setBreadCrumbTitle(titleRes);
    } else if (titleText != null) {
        transaction.setBreadCrumbTitle(titleText);
    }
    transaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
    transaction.addToBackStack(BACK_STACK_PREFS);
    transaction.commitAllowingStateLoss();
}