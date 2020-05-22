float angle = (float) (System.currentTimeMillis() % ROTATE_TIME_MILLIS) 
   / ROTATE_TIME_MILLIS * 360;
matrix.reset();
matrix.postTranslate(-source.getWidth() / 2, -source.getHeight() / 2);
matrix.postRotate(angle);
matrix.postTranslate(centerX, centerY)
canvas.drawBitmap(source, matrix, null);
invalidate(); // Cause a re-draw