Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
    intent.setType("file/*");
    startActivityForResult(intent, YOUR_REQUEST_CODE);

@Override
protected void onActivityResult(int requestCode, int resultCode, Intent data) {
  if (resultCode == RESULT_OK) {
    switch (requestCode) {
    case YOUR_REQUEST_CODE:
      //get the uri from data's extras
      break;
    }
     //do whatever you want with uri
  } else {
    Toast.makeText(this, "Wrong result", Toast.LENGTH_SHORT).show();
  }
}