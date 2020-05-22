if (selectedImage != null && "content".equals(selectedImage.getScheme())) {
   Cursor cursor = this.getContentResolver().query(selectedImage, new String[] { android.provider.MediaStore.Images.ImageColumns.DATA }, null, null, null);
   cursor.moveToFirst();   
   path = cursor.getString(0);
   cursor.close();
} else {
   path = selectedImage.getPath();
}