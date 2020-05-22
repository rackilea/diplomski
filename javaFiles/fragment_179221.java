@Override
protected void onActivityResult(int requestCode, int resultCode, Intent data) {
    if (requestCode == REQUEST_CODE && resultCode == Activity.RESULT_OK && data != null) {

         number = getIntent().getExtras().getInt("number");

    }
}