@Override
protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == Activity.RESULT_OK) {
           if (requestCode == PICK_IMAGE) {
                Uri selectedImageUri = data.getData();
                String imagePath = getRealPathFromURI(selectedImageUri);
               //Now you have imagePath do whatever you want to do now
             }//end of inner if
         }//end of outer if
  }

public String getRealPathFromURI(String contentURI) {
    Uri contentUri = Uri.parse(contentURI);

    String[] projection = { MediaStore.Images.Media.DATA };
    Cursor cursor = null;
    try {
        if (Build.VERSION.SDK_INT > 19) {
            // Will return "image:x*"
            String wholeID = DocumentsContract.getDocumentId(contentUri);
            // Split at colon, use second item in the array
            String id = wholeID.split(":")[1];
            // where id is equal to
            String sel = MediaStore.Images.Media._ID + "=?";

            cursor = context.getContentResolver().query(
                    MediaStore.Images.Media.EXTERNAL_CONTENT_URI,
                    projection, sel, new String[] { id }, null);
        } else {
            cursor = context.getContentResolver().query(contentUri,
                    projection, null, null, null);
        }
    } catch (Exception e) {
        e.printStackTrace();
    }

    String path = null;
    try {
        int column_index = cursor
                .getColumnIndex(MediaStore.Images.Media.DATA);
        cursor.moveToFirst();
        path = cursor.getString(column_index).toString();
        cursor.close();
    } catch (NullPointerException e) {
        e.printStackTrace();
    }
    return path;
}