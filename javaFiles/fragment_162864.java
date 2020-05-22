public void onResume() {
    super.onResume();
    uiHelper.onResume();
}
 public void onPause() {
    super.onPause();
    uiHelper.onPause();
}

@Override
public void onActivityResult(int requestCode, int resultCode, Intent data) {
    super.onActivityResult(requestCode, resultCode, data);
    uiHelper.onActivityResult(requestCode, resultCode, data);
}

@Override
public void onDestroy() {
    super.onDestroy();
    uiHelper.onDestroy();
}

@Override
protected void onSaveInstanceState(Bundle outState) {
    super.onSaveInstanceState(outState);
    uiHelper.onSaveInstanceState(outState);
}