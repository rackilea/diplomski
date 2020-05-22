public void rotateBy90() 
{
    // bla bla
    char[][] tempShape = new char[width][height];

    for(int j = 0; j < width; j++) {
        for(int i = 0; i < height; i++) {
            tempShape[...][...] = myShape[i][j]; //I'll leave this as exercise
        }
    }

    myShape = tempShape;
}