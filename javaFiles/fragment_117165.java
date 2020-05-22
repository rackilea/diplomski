Bitmap  bitmap2 = Bitmap.createBitmap(200, 200, Bitmap.Config.ARGB_8888);
    Canvas canvas2 = new Canvas(bitmap2);       
    canvas2.drawColor(Color.WHITE);
    Paint rectPaint2 = new Paint();
    rectPaint2.setColor(Color.GREEN);
    canvas2.drawRect(20, 20, 180, 180, rectPaint2);
    Matrix matrix2 = new Matrix();
    float deform2 = 20f;
    float[] src2 = new float[] { 0, 0, bitmap2.getWidth(), 0, bitmap2.getWidth(), bitmap2.getHeight(), 0, bitmap2.getHeight() };
    float[] dst2 = new float[] { 0, 0, bitmap2.getWidth() - deform2, deform2, bitmap2.getWidth() - deform2, bitmap2.getHeight() - deform2, 0, bitmap2.getHeight() };
    matrix2.setPolyToPoly(src2, 0, dst2, 0, src2.length >> 1);
    Bitmap bMatrix2= Bitmap.createBitmap(bitmap2, 0, 0, bitmap2.getWidth(), bitmap2.getHeight(), matrix2, true);

    ImageView ivSecond = (ImageView) findViewById(R.id.ivSecond);
    ivSecond.setImageBitmap(bMatrix2);