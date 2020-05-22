private void switchFragment(Fragment fragment) {
    if (getActivity() == null) {
        return;
    }

    MainActivity mainActivity = (MainActivity)getActivity();
    mainActivity.switchContent(fragment);
}