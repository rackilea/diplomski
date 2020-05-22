ImageView imageView = findViewById(R.id.image);
Bitmap bitmap = ((BitmapDrawable) imageView.getDrawable()).getBitmap();

//save the image now:
saveImage(bitmap);
//share it
send();