@Override
protected void onActivityResult(int requestCode, int resultCode, Intent data) {
    if (requestCode == 11111 && resultCode == Activity.RESULT_OK) {
        long date = data.getExtras().getLong("date");
    }
}