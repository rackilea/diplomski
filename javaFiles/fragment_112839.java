BitmapDrawable bitDraw = (BitmapDrawable) this.getDrawable();
Bitmap bitmap = bitDraw.getBitmap();

//paint for the text
Paint paint = new Paint();
paint.setAntiAlias(true);
paint.setColor(Color.WHITE);
paint.setTextSize((int) getTextSize() * scale);
paint.setShadowLayer(1f, 0f, 1f, Color.BLACK);

//draw the text to specific position
Rect bounds = new Rect();
paint.getTextBounds(String.valueOf(getNotificationAmount()), 0, String.valueOf(getNotificationAmount()).length(), bounds);
int x = bitmap.getWidth() - bounds.width();
int y = bitmap.getHeight() - bounds.height();
canvas.drawText(String.valueOf(getNotificationAmount()), x, y, paint);