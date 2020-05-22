InputStream imageStream = null;
try {
    // get input stream
    imageStream  = getAssets().open("foxtail.png");
    // load image as Drawable
    Drawable drawable= Drawable.createFromStream(imageStream, null);
    // set image to ImageView
    image.setImageDrawable(drawable);
    }
catch(IOException ex) {
    return;
}