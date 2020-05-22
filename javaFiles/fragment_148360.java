protected void onActivityResult(int requestCode, int resultCode, Intent imageReturnedIntent) {
   super.onActivityResult(requestCode, resultCode, imageReturnedIntent);

   switch(requestCode) {
   case 0:
       if (requestCode == 0 && resultCode == RESULT_OK) {
        Bitmap photo = (Bitmap) data.getExtras().get("data");           
        // CALL THIS METHOD TO GET THE URI FROM THE BITMAP
        Uri tempUri = getImageUri(getApplicationContext(), photo);
        // CALL THIS METHOD TO GET THE ACTUAL PATH
        casted_image = new File(getRealPathFromURI(tempUri));
        System.out.println(tempUri);
    }  
   break;
   case 1:
       //handle gallery code here

        break;
  }
}

public Uri getImageUri(Context inContext, Bitmap inImage) {
    ByteArrayOutputStream bytes = new ByteArrayOutputStream();
    inImage.compress(Bitmap.CompressFormat.JPEG, 100, bytes);
    String path = Images.Media.insertImage(inContext.getContentResolver(), inImage, "Title", null);
    return Uri.parse(path);
}

public String getRealPathFromURI(Uri uriTemp) {
    Cursor cursor = getContentResolver().query(uriTemp, null, null, null, null); 
    cursor.moveToFirst(); 
    int mIndex = cursor.getColumnIndex(MediaStore.Images.ImageColumns.DATA); 
    return cursor.getString(mIndex); 
}