@Override
protected void onActivityResult(int requestCode, int resultCode, Intent data) {
    super.onActivityResult(requestCode, resultCode, data);
    if (resultCode == 1) {
        Intent intent = new Intent();
        intent.putExtra("MESSAGE", message);
        setResult(1, intent);
        finish();
    }
}