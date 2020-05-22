@Override
protected void onActivityResult(int requestCode, int resultCode, Intent data) {
    if (requestCode == 123 && resultCode == Activity.RESULT_OK) {
        float result = data.getExtras().getFloat("result");
        // Do whatever you want with "result"
    }
}