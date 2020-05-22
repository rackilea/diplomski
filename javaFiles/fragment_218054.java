BitmapFactory.Options options = new BitmapFactory.Options();
Bitmap original = BitmapFactory.decodeFile(path, options);
try {
    File file = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS), "name".png");
    OutputStream fOut = new FileOutputStream(file);

    //The size of the two bitmaps below should be equal
    Bitmap resultImg = Bitmap.createBitmap(200, 200, Bitmap.Config.ARGB_8888);
    Bitmap maskImg = Bitmap.createBitmap(200, 200, Bitmap.Config.ARGB_8888);

    Canvas mCanvas = new Canvas(resultImg);
    Canvas maskCanvas = new Canvas(maskImg);

    Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
    paint.setAntiAlias(true);
    paint.setStyle(Paint.Style.FILL);
    paint.setXfermode(new PorterDuffXfermode(Mode.DST_ATOP));

    Path path = new Path();
    path.moveTo(200,200);
    path.lineTo(400,200);
    path.lineTo(400,400);
    path.lineTo(200,400);
    path.close();

    maskCanvas.drawPath(path, paint);
    mCanvas.drawBitmap(original, 0, 0, null);
    //The following should have appropriate x,y for the path(here 200)
    mCanvas.drawBitmap(maskImg, 200, 200, paint);

    resultImg.compress(Bitmap.CompressFormat.PNG, 100, fOut);
    fOut.flush();

if (fOut != null) {
    fOut.close();
}
} catch (IOException e){
    e.printStackTrace();
}