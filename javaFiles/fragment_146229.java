// Closing hardware acceleration
setLayerType(LAYER_TYPE_SOFTWARE, paint);

paint.getTextBounds(first, 0, first.length(), bounds);
float posX = (canvas.getWidth() - bounds.width()) / 2; // center
float posY = ((canvas.getHeight() - bounds.height()) / 2); // center

canvas.scale(1, 10, posX, posY);
canvas.drawText(first, posX, posY, paint);