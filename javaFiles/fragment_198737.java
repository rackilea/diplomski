Bitmap bitmap = Bitmap.createBitmap(/* width */, /* height */, Config.ARGB_8888);
Paint alpha = new Paint();
alpha.setAlpha(/* alpha */);
Canvas canvas = new Canvas(bitmap);
Bitmap background = BitmapFactory.decodeResource(
    getResources(), R.drawable.background);
Bitmap foreground = BitmapFactory.decodeResource(
    getResources(), R.drawable.pattern);
canvas.drawBitmap(background, /* xPos */, /* yPos */, null);
canvas.drawBitmap(foreground, /* xPos */, /* yPos */, alpha);