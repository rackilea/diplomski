private void switchFragment(Fragment fragment) {
if (getActivity() == null) {
    return;
}

MainActivity mainActivity = new MainActivity();
    mainActivity.switchContent(fragment);
}