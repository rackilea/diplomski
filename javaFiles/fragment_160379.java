Point2D levelContainer[] = new Point2D[5];
    //set the R level
    levelContainer[0] = new Point2D.Double(0, 50);
    //set the rest
    levelContainer[1] = new Point2D.Double(50, 60);
    levelContainer[2] = new Point2D.Double(60, 70);
    levelContainer[3] = new Point2D.Double(70, 80);
    levelContainer[4] = new Point2D.Double(80, Double.MAX_VALUE);

    double exampleMark[] = {2, 56, 63, 70, 8080};

    for(int index = 0; index < exampleMark.length; index++)
    {
        //now for every mark we have, we need to loop the level array until we find the which level it falls in
        for(int levelIndex = 0; levelIndex < levelContainer.length; levelIndex++)
        {
            //now check the X, our minimum value, and the Y,our max value, for our range and if it does fall into the range print out the level
            if(exampleMark[index] >= levelContainer[levelIndex].getX() && exampleMark[index] < levelContainer[levelIndex].getY())
            {
                //basically use R if the level the mark falls into is 0
                String level = levelIndex == 0 ? "R" : new Integer(levelIndex).toString();
                System.out.println("Our current mark is " + exampleMark[index] + " which falls between " 
                        + levelContainer[levelIndex].getX() + " and " +
                        levelContainer[levelIndex].getY() + " which is level " + level);
            }
        }
    }