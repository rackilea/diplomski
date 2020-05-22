Bitmap bitmap = Bitmap.createBitmap(width, height, Config.ARGB_8888);
for (int i = 0; i < width; i++) {
    for (int j = 0; j < height; j++) {
        bitmap.setPixel(i, j, Color.argb(255, 255, 0, 0));
     }
 }