Bundle extras = getIntent().getExtras();
byte[] byteArray = extras.getByteArray("picture");

Bitmap bmp = BitmapFactory.decodeByteArray(byteArray, 0, byteArray.length);
ImageView image = (ImageView) findViewById(R.id.imageView1);

image.setImageBitmap(bmp);