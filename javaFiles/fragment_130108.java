public boolean collision() {
    boolean onFloor = false;
    Rectangle rectangle = getBounds();
    for (Floor floor : floors) {
        if (floor.getBounds().intersects(rectangle)) {
            onFloor = true;
            break;
        }
    }
    return onFloor;
}