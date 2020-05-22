@Override
protected void onActivityResult(int requestCode, int resultCode, Intent data) {
    // Check which request we're responding to
    if (requestCode == RESULT_REQUEST) {
    // Make sure the request was successful
    if (resultCode == RESULT_OK) {
        String result = data.getStringExtra("result");
    }
    }
}