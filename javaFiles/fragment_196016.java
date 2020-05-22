imageView.buildDrawingCache();
Bitmap image= imageView.getDrawingCache();

 Bundle extras = new Bundle();
extras.putParcelable("imagebitmap", image);
intent.putExtras(extras);
startActivity(intent);


Bundle extras = getIntent().getExtras();
Bitmap bmp = (Bitmap) extras.getParcelable("imagebitmap");

image.setImageBitmap(bmp );