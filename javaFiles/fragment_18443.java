ImageView imageView = (ImageView) findViewById(R.id.imageView);
Bitmap bitmap = ((BitmapDrawable) imageView.getDrawable()).getBitmap();
ByteArrayOutputStream baos = new ByteArrayOutputStream();
bitmap.compress(Bitmap.CompressFormat.JPEG, 100, baos);
byte[] imageInByte = baos.toByteArray();
//save your stuff