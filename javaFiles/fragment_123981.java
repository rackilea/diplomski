protected void onActivityResult(int requestCode, int resultCode, 
       Intent imageReturnedIntent) {
    super.onActivityResult(requestCode, resultCode, imageReturnedIntent); 

    switch(requestCode) { 
    case REQ_CODE_PICK_IMAGE:
        if(resultCode == RESULT_OK){  
            Uri selectedImage = imageReturnedIntent.getData();
            String[] filePathColumn = {MediaStore.Images.Media.DATA};

            Cursor cursor = getContentResolver().query(
                               selectedImage, filePathColumn, null, null, null);
            cursor.moveToFirst();

            int columnIndex = cursor.getColumnIndex(filePathColumn[0]);
            String filePath = cursor.getString(columnIndex);
            cursor.close();


            Bitmap yourSelectedImage = BitmapFactory.decodeFile(filePath);
        }
    }
}