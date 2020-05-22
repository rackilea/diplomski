public void createGameObjects() 
{
    ball = new GameObject(W / 2, H / 2, BALL_SIZE, BALL_SIZE, Colour.RED);
    bat = new GameObject(W / 2, H - BRICK_HEIGHT * 4, BRICK_WIDTH * 3,
            BRICK_HEIGHT, Colour.GRAY);
    bricks = new GameObject[BRICKS];

    // *[1]**********************************************************
    // * Fill in code to place the bricks on the board *
    // **************************************************************

    bricks[0] = new GameObject(0, 0, BRICK_HEIGHT, BRICK_WIDTH, Colour.BLUE);
}