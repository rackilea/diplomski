bitmap = android.provider.MediaStore.Images.Media.getBitmap(cr, imageUri);
  photo_new= rotateImage(bitmap, 90);
  ByteArrayOutputStream stream = new ByteArrayOutputStream();

  photo_new.compress(Bitmap.CompressFormat.JPEG, 100, stream);
  byte[] byteArray = stream.toByteArray();
  bitmap.recycle();
  Intent i = new Intent(getApplicationContext(),new_class.class);
  i.putExtra("image", byteArray);

  startActivity(i);
  byteArray=null;