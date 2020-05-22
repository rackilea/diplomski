while (true) {
    currentPoint = MouseInfo.getPointerInfo().getLocation();
    if (currentPoint != startPoint && clicked) {
        drawRectangle(startPoint, currentPoint, picture1);
    }
//System.out.println(currentPoint);
    //delay(1);
}