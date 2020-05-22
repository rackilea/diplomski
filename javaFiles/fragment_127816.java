@Override
protected void onSaveInstanceState(Bundle outState) {
    //
    // saving other values...
    //
    outState.putInt("radGroup1", resultGroup.getCheckedRadioButtonId());
    outState.putInt("radGroup2", valueGroup.getCheckedRadioButtonId());
    Log.d(TAG, "onSaveInstanceState: result id " + resultGroup.getCheckedRadioButtonId() + ", value id = " + valueGroup.getCheckedRadioButtonId());
    super.onSaveInstanceState(outState);
}