//Start Activity B 
startActivityForResult(new Intent(this, B.class), 1);

@Override
protected void onActivityResult(int requestCode, int resultCode, Intent data) {
    if (resultCode == RESULT_OK) {
        startActivity(new Intent(this, C.class));
        finish();
    }
}