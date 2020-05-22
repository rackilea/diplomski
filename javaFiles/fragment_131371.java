/**
 * Take care of popping the fragment back stack or finishing the activity
 * as appropriate.
 */
@Override
public void onBackPressed() {
    FragmentManager fragmentManager = mFragments.getSupportFragmentManager();
    final boolean isStateSaved = fragmentManager.isStateSaved();
    if (isStateSaved && Build.VERSION.SDK_INT <= Build.VERSION_CODES.N_MR1) {
        // Older versions will throw an exception from the framework
        // FragmentManager.popBackStackImmediate(), so we'll just
        // return here. The Activity is likely already on its way out
        // since the fragmentManager has already been saved.
        return;
    }
    if (isStateSaved || !fragmentManager.popBackStackImmediate()) {
        super.onBackPressed();
    }
}