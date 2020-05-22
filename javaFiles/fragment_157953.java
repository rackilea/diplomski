public static void setThemeGrid()
{   
    //fills temp grid with 8 elements x2
    List themeList = new ArrayList()
    for (int counter = 0; counter < 4; counter++)
    {
        themeList.add(states[counter]);
        themeList.add(states[counter]);
        themeList.add(states[counter+4]);
        themeList.add(states[counter+4]);
    }
    Collections.shuffle(themeList);

    System.out.println("This is the randomized theme grid");
    for (int row = 0; row < 4; row++)
    {
        for (int column = 0; column < 4; column++)
        {
            themeGrid[row][column] = themeList.get(row*4 + column);
            System.out.printf("%s ", themeGrid[row][column]);
        }
        System.out.println();
    }
}