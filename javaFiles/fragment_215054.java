private boolean isGameOver(int headLocX, int headLocY) {

    for (int i = SNAKE_LENGTH_DEFAULT; i < totalBodyPart - 2; i++) {
        Point partLoc = snakeBodyPart[i].getLocation();
        if (partLoc.equals(new Point(headLocX, headLocY))) {
            Testing test = new Testing(score);//This is the correct way to initialize the Testing class.
            return true;
        }
    }