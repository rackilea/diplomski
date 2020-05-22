final int GRID_WIDTH = 10;
final int GRID_HEIGHT = 10;
final int BOMB_NUMBER = 10;
final boolean[][] minesArray = new boolean[GRID_WIDTH][GRID_HEIGHT];
for (int i = 0; i < BOMB_NUMBER; i++) {
     //Get random position for the next bomb
     Random rand = new Random();
     int row = rand.nextInt(GRID_WIDTH);
     int col = rand.nextInt(GRID_HEIGHT);
     while(minesArray[row][col]) { //if this position is a bomb
          //we get new position
          row = rand.nextInt(GRID_WIDTH);
          col = rand.nextInt(GRID_HEIGHT);
     }
     minesArray[row][col] = true; //make new position is a bomb
}