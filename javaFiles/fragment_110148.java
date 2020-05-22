// Here you create the bound of your shape
Rect rect = new Rect(0, 0, 1, 1);

// You then create a Bitmap and get a canvas to draw into it
Bitmap image = Bitmap.createBitmap(rect.width(), rect.height(), Config.ARGB_8888);
Canvas canvas = new Canvas(image);

//You can get an int value representing an argb color by doing so. Put 1 as alpha by default
int color = Color.argb(alpha, red, green, blue);

//Paint holds information about how to draw shapes
Paint paint = new Paint();
paint.setColor(color);

// Then draw your shape
canvas.drawRect(rect, paint);