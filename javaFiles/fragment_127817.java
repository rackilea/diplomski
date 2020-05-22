private int checkedResultButtonsId;
private int checkedValueButtonsId;

@Override
protected void onRestoreInstanceState(Bundle savedInstanceState) {
    super.onRestoreInstanceState(savedInstanceState);
    checkedResultButtonsId = savedInstanceState.getInt("radGroup1");
    checkedValueButtonsId = savedInstanceState.getInt("radGroup2");
    Log.d(TAG, "onRestoreInstanceState: result id " + checkedResultButtonsId + ", value id = " + checkedValueButtonsId);
}