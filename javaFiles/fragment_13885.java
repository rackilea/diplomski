private static final int halfAlpha = 255 / 2;
private static final int opaque = 255;

ImageView imageOne = (ImageView) findViewById(R.id.image_one);
imageOne.setImageAlpha(halfAlpha);
ImageView imageTwo = (ImageView) findViewById(R.id.image_two);
imageTwo.setImageAlpha(opaque);