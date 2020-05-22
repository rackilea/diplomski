ImageView imageView = (ImageView) findViewById(R.id.photo_taken);
int width = imageView.getMeasuredWidth();
int height = imageView.getMeasuredHeight();

File file = //get your file
Bitmap bitmap = CameraUtils.decodeSampledBitmap(file, height, width);
imageView.setImageBitmap(bitmap);