// Choose a new location for the cursor
    int direction = rand.nextInt(4);  //0=left, 1=right, 2=up, 3=down
    if (direction == 0){
        x -= CURSOR_DIM; //The step should be equal to the cursor width, not 1
    } else if (direction == 1){
        x += CURSOR_DIM;
    } else if (direction == 2){
        //you usually subtract to go up, the origin being the upper-left corner
        y -= CURSOR_DIM;
    } else if (direction == 3) {
        y += CURSOR_DIM;
    }