void createBorders(int widthUnits, int heightUnits, boolean[][] activeMap) {
    for(int x=0;x<widthUnits;x++) {
        for(int y=0;y<heightUnits;y++) {
            if(!activeMap[x][y])    // boolean "map" (true if active)
                continue;

            if(x == 0)
                addBorder(LEFT, x, y);
            else if(!activeMap[x-1][y])
                addBorder(LEFT, x, y);

            if(x == widthUnits-1)
                addBorder(RIGHT, x, y);
            else if(!activeMap[x+1][y])
                addBorder(RIGHT, x, y);

            if(y == 0)
                addBorder(TOP, x, y);
            else if(!activeMap[x][y-1])
                addBorder(TOP, x, y);

            if(y == heightUnits-1)
                addBorder(BOTTOM, x, y);
            else if(!activeMap[x][y+1])
                addBorder(BOTTOM, x, y);
        }
    }
}