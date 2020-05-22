@Override
protected void onActivityResult(int requestCode, int resultCode, Intent data) {
    super.onActivityResult(requestCode, resultCode, data);
    if (requestCode == SUB_ACTIVITY_REQUEST_CODE) {
        Bundle b = data.getExtras();
        String result = b.getString("myResult");
    }
}