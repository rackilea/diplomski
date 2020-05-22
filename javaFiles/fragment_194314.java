public int getGeneralizedValueX(int x) {
    return (int) (AppConstants.CANVAS_WIDTH * (x / 1280f));
}

public int getGeneralizedValueY(int y) {
    return (int) (AppConstants.CANVAS_HEIGHT * (y / 720f));
}