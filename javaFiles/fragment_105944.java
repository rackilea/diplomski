@Override
  public void onActivityResult(int requestCode, int resultCode, Intent data) {
    super.onActivityResult(requestCode, resultCode, data);
    switch (requestCode) {
    case 1:
     {
      if (resultCode == RESULT_OK)
      {
        Uri photoUri = data.getData();
        if (photoUri != null)
        {
        try {
              String[] filePathColumn = {MediaStore.Images.Media.DATA};
              Cursor cursor = getContentResolver().query(photoUri, filePathColumn, null, null, null); 
         cursor.moveToFirst();
     int columnIndex = cursor.getColumnIndex(filePathColumn[0]);
     String filePath = cursor.getString(columnIndex);
     cursor.close();
     Bitmap bitmap = BitmapFactory.decodeFile(filePath);
     imgView.setImageBitmap(bitmap);
     int size = bitmap.getWidth() * bitmap.getHeight();
     ByteArrayOutputStream out = new ByteArrayOutputStream(size);
     bitmap.compress(Bitmap.CompressFormat.PNG, 100, out);
     try {
     out.flush();
     out.close();
     } catch (IOException e) {
     e.printStackTrace();}
     String bb = out.toString();
     byte[] x = out.toByteArray();
     image_value.setTag(x);
     image_value.setText(filePath);
     }catch(Exception e)
      {}
      }
    }
    }