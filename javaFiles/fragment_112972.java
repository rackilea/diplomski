public void onActivityResult(final int requestCode, final int resultCode, final Intent data) {
    if (requestCode == 0) {
            if (resultCode == Activity.RESULT_OK) {
                    final String result = data.getStringExtra("SCAN_RESULT"); // Get scanning result
                    final String type = data.getStringExtra("code_type"); // Get code type
            } else {
                    // Not scan any code yet
            }
    }
}