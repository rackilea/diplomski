private static void draw() {
    drawWith(random(0,20), random(0,10));
}

private static void drawWith(int width, int height) {
    for (int a=random(2,4); a>0; a--) {
        rectangle(width, height);
    }       
}

private static void rectangle(int width, int height) {
    halfRect(width, height);
    halfRect(width, height);

}

private static void halfRect(int width, int height) {
    walkRandom(width, true);
    turnLeft();
    walkRandom(height, true);
}