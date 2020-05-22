@Override
protected void onActivityResult(int requestCode, int resultCode, Intent data) {

    if (requestCode == REQUEST_CODE) {

        if (resultCode == Activity.RESULT_OK) {
            String result = data.getStringExtra("extra_data");
            // do something with the result

        } else if (resultCode == Activity.RESULT_CANCELED) {
            // some stuff that will happen if there's no result
        }
    }
}