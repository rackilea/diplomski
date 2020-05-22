static final int MAP_REQUEST = 1;  // your request code
...
private void callOtherActivity() {
    Intent intent = new Intent(this, OtherActivity.class)
    startActivityForResult(intent, MAP_REQUEST);
}