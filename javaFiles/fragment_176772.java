@Override
protected void onActivityResult(int requestCode, int resultCode, Intent data) {
    if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK) {
        ...            // same above mentioned code

        // display your input in TextView
        Text.setText(inputcommand );
    }
}