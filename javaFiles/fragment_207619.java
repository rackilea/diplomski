AnimationDrawable animation = new AnimationDrawable();
ImageView image = (ImageView) findViewById(R.id.sign);

for (int i = 0; i < translate_text.length(); i++)
{
    byte[] byteArray = Base64.getDecoder().decode(client._fromServer.elementAt(i));
    Bitmap bmp = BitmapFactory.decodeByteArray(byteArray, 0, byteArray.length);
    final Bitmap scaledBitmap = Bitmap.createScaledBitmap(bmp, image.getWidth(), image.getHeight(), false);
    Drawable drawable = new BitmapDrawable(getResources(), scaledBitmap);
    animation.addFrame(drawable, 1000);
}

animation.setOneShot(true);
animation.start();