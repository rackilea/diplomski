public void collisionChecker(int playerX, int playerY){ //takes the user's location and then checks if they are running into the wall
    if(mazeWalls[playerY / 50][playerX / 50] == 1 ){
        setCollision(true);
    }
    else if(mazeWalls[playerY / 50][playerX / 50] != 1){
        setCollision(false); //just in case
    }
}