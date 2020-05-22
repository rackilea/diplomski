private boolean isGameOver(int headLocX, int headLocY) {

    for (int i = SNAKE_LENGTH_DEFAULT; i < totalBodyPart - 2; i++) {
        Point partLoc = snakeBodyPart[i].getLocation();
        if (partLoc.equals(new Point(headLocX, headLocY))) {
            Testing test = new Testing();
            Testing(score);//It is an invalid call no method is defined like this or a class can't be initialized like this.
            return true;
        }
    }