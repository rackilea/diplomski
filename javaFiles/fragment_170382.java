final int saveCount = canvas.save();
try {
    canvas.translate(addOffset, 0);

    canvas.drawBitmapMesh(GirlBitmap, WIDTH, HEIGHT, matrixVertsMoved, 0,  null, 0, null); 
    canvas.drawCircle(pointX, pointY, bubbleSize, p3);
} finally {
    canvas.restoreToCount(saveCount);
}