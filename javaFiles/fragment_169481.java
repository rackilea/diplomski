protected void onActivityResult(int requestCode, int resultCode, Intent data) {

    Log.i(tag, "onActivityResult()");
    if (requestCode == REQUEST_CODE ) {
        if (resultCode == RESULT_OK) {
            String m = data.getStringExtra(SecondActivity.EXTRA_MESSAGE);
            mTextView.setText(m);
        }
    }
}