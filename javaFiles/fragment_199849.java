Bitmap src = BitmapFactory.decodeResource(getResources(), R.drawable.yourimage); // the original file yourimage.jpg i added in resources
    Bitmap dest = Bitmap.createBitmap(src.getWidth(), src.getHeight(), Bitmap.Config.ARGB_8888);

    String yourText = "My custom Text adding to Image";

    Canvas cs = new Canvas(dest);
    Paint tPaint = new Paint();
    tPaint.setTextSize(35);
    tPaint.setColor(Color.BLUE);
    tPaint.setStyle(Style.FILL);
    cs.drawBitmap(src, 0f, 0f, null);
    float height = tPaint.measureText("yY");
    float width = tPaint.measureText(yourText);
    float x_coord = (src.getWidth() - width)/2;
    cs.drawText(yourText, x_coord, height+15f, tPaint); // 15f is to put space between top edge and the text, if you want to change it, you can
    try {
        dest.compress(Bitmap.CompressFormat.JPEG, 100, new FileOutputStream(new File("/sdcard/ImageAfterAddingText.jpg")));
        // dest is Bitmap, if you want to preview the final image, you can display it on screen also before saving
    } catch (FileNotFoundException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    }