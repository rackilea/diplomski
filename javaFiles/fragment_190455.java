static void displayPathtoPrincess(int n, int p,char [][] grid){

    Point bot;
    Point princess;

    getInitialPositions(bot, princess, grid);

    Point dif = getRelativePrincessPosition(bot, princess);

    while (!bot.equals(princess)) {
        switch (dif.y) {
            case UP:
                move (UP_MOVEMENT);
                break;
            case DOWN:
                move (DOWN_MOVEMENT);
                break;
        }
        switch (dif.x) {
            case LEFT:
                move(LEFT_MOVEMENT);
                break;
            case RIGHT:
                move(RIGHT_MOVEMENT);
                break;
        }
    }
}