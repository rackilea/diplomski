@Override
 protected void onActivityResult(int requestCode ,int resultCode ,Intent data ) {
    super.onActivityResult(requestCode, resultCode, data);
    String name = data.getStringExtra("ANSWER");
    if (resultCode == RESULT_OK) {
      Toast.makeText(this, name, Toast.LENGTH_LONG).show();
    }
 }