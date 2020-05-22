public static boolean rectangleCircleIntersection(RectangleRegion rect, CircularRegion circle, int padding) {
    int paddedRadius = circle.getRadius() + padding;
    int circleDistance_x = PsyMath.abs((circle.getX()+paddedRadius) - (rect.getX()+rect.getWidth()/2));
    int circleDistance_y = PsyMath.abs((circle.getY()+paddedRadius) - (rect.getY()+rect.getHeight()/2));

    if (circleDistance_x > (rect.getWidth()/2 + paddedRadius)) { return false; }
    if (circleDistance_y > (rect.getHeight()/2 + paddedRadius)) { return false; }

    if (circleDistance_x <= (rect.getWidth()/2)) { return true; } 
    if (circleDistance_y <= (rect.getHeight()/2)) { return true; }

    int cornerDistance_sq = (int)Math.pow((circleDistance_x - rect.getWidth()/2),2) +
                         (int)Math.pow((circleDistance_y - rect.getHeight()/2),2);

    return (cornerDistance_sq <= (int)Math.pow(paddedRadius,2));
}