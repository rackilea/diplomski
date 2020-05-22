public void update() {
    Segment snakeHead = snake.getSegments()[0];
    checkFoodCol(snakeHead);
    changeHeadLoc(snakeHead);
    changeSegmentLoc();
}