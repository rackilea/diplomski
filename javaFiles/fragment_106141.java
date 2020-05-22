private void createBitMap() {

    Bitmap bitMap = Bitmap.createBitmap(100, 100, Bitmap.Config.ARGB_8888);  //creates bmp
    bitMap = bitMap.copy(bitMap.getConfig(), true);     //lets bmp to be mutable
    Canvas canvas = new Canvas(bitMap);                 //draw a canvas in defined bmp

    Paint paint = new Paint();                          //define paint and paint color
    paint.setColor(Color.RED);
    paint.setStyle(Style.FILL_AND_STROKE);
    //paint.setStrokeWidth(0.5f);
    paint.setAntiAlias(true);                           //smooth edges


    ImageView imageView = (ImageView) findViewById(R.id.imageView);
    imageView.setImageBitmap(bitMap);
    //changed set image resource to set image background resource
    imViewAndroid.setBackgroundResource(R.drawable.map);
    canvas.drawCircle(50, 50, 3, paint);
    //invalidate to update bitmap in imageview
    imageView.invalidate();

}