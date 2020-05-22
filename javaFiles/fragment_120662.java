saveImageBitmap(Bitmap bitmap){
ByteArrayOutputStream baos = new ByteArrayOutputStream();
    bitmap.compress(Bitmap.CompressFormat.JPEG, 20, baos);
    byte[] data = baos.toByteArray();

  //do whatever you want to save this bitmap file 
}