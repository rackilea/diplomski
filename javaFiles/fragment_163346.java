@Override
public void onActivityResult(int requestCode, int resultCode, Intent data) {
    super.onActivityResult(requestCode, resultCode, data);
    for (Fragment fragment : getChildFragmentManager().getFragments()) {
        fragment.onActivityResult(requestCode, resultCode, data);
    }
}