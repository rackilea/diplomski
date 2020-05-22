@Override
public void onBackPressed() {
    final WebViewFragment fragment = (WebViewFragment) fragmentManager.findFragmentById(fragmentId);
    if (fragment == null || !fragment.onBackPressed()) {
        super.onBackPressed();
    }
}