@Override
protected void onActivityResult(int requestCode, int resultCode, Intent data) {
    if (requestCode == MAP_REQUEST) {
        // Make sure the request was successful
        if (resultCode == RESULT_OK) {
            updateMap();
        }
    }
}