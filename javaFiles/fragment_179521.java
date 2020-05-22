static void Navigator(int locX, int locY, int[][] myArray, String Path)
{
    int newX = 0;
    int newY = 0;

    Path = Path.concat("["+locX+","+locY+"]");

    if ((locX == 0 || locX == myArray.length-1 || locY == 0 || locY == myArray[0].length-1))
    {//Edge Found
        System.out.println(Path);
        pathCnt++;
        myArray[locX][locY] = 1;
        return;
    }

    for (int row = -1; row <= 1; row++)
    {            
        for (int col = -1; col <= 1; col++)
        {
            if (!(col == 0 && row == 0) && (myArray[locX+row][locY+col] == 1))
            {   //Valid Path Found
                myArray[locX][locY] = 0;
                Navigator(locX+row, locY+col, myArray, Path);
            }
        }
    }

    //Dead End Found
    myArray[locX][locY] = 1;
    return;
}       System.out.println(Path);
        pathCnt++;
        swamp[locX][locY] = 1;
        return;
    }

    for (int row = -1; row <= 1; row++)
    {            
        for (int col = -1; col <= 1; col++)
        {
            if (!(col == 0 && row == 0) && (swamp[locX+row][locY+col] == 1))
            {   //Valid Path Found
                swamp[locX][locY] = 0;
                Navigator(locX+row, locY+col, swamp, Path);
            }
        }
    }

    //Dead End Found
    swamp[locX][locY] = 1;
    return;
}