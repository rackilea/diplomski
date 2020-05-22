private void pyramid(){
    int xBase = 0;
    int yCoord = getHeight() - BRICK_HEIGHT;
    // 12 rows of decreasing length: 12, 11,... 1
    for( int rowlen = 12; rowlen >= 1; --rowlen ){
        // lay the bricks - calculate x-coordinate
        for( int iBrick = 0; iBrick < rowlen; ++iBrick ){
            add( brick(), xBase + iBrick*BRICK_WIDTH, yCoord );
        }
        // indent for next row
        xBase += 15;
        // advance vertically
        yCoord -= BRICK_HEIGHT;
    }