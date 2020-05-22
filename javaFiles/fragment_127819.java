@Override
protected void onRestoreInstanceState(Bundle savedInstanceState) {
    super.onRestoreInstanceState(savedInstanceState);
    checkedResultButtonsId = savedInstanceState.getInt("radGroup1");
    checkedValueButtonsId = savedInstanceState.getInt("radGroup2");
}