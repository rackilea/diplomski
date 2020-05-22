private void checkDirection(Location point, int player, int yStep, int xStep) {
    int x = point.getHorizontal() + xStep;
    int y = point.getVertical() + yStep;

    MyLocation locationBeingChecked = new MyLocation();
    locationBeingChecked.setHorizontal(x);
    locationBeingChecked.setVertical(y);

    while (isValid(locationBeingChecked)) {
        // do the logic here

        x += xStep;
        y += yStep;

        locationBeingChecked = new MyLocation();
        locationBeingChecked.setHorizontal(x);
        locationBeingChecked.setVertical(y);
    }
}