protected Point getPointOnCircle(float degress, float radius) {

    int x = Math.round(getWidth() / 2);
    int y = Math.round(getHeight() / 2);

    double rads = Math.toRadians(degress - 90); // 0 becomes the top

    // Calculate the outter point of the line
    int xPosy = Math.round((float) (x + Math.cos(rads) * radius));
    int yPosy = Math.round((float) (y + Math.sin(rads) * radius));

    return new Point(xPosy, yPosy);

}