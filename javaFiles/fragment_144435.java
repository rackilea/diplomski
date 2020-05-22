/**
 * Handle the results from the recognition activity.
 */
@Override
protected void onActivityResult(int requestCode, int resultCode, Intent data) {
    if (requestCode == VOICE_RECOGNITION_REQUEST_CODE && resultCode == RESULT_OK) {
        // Fill the list view with the strings the recognizer thought it could have heard
        ArrayList<String> matches = data.getStringArrayListExtra(
                RecognizerIntent.EXTRA_RESULTS);
        mList.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,
                matches));
    }

    super.onActivityResult(requestCode, resultCode, data);
}