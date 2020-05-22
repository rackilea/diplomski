// make a grid to draw the chart
    // the height is the the number we defined as maximum height (xLength)
    // and the width is one column for every char (charCount.length):
    String[][] grid = new String[charCount.length][xLength];

    // initialize the grid with spaces:
    for(int x = 0; x < grid.length; x++) {
        for(int y = 0; y < grid[x].length; y++) {
            grid[x][y] = " ";
        }
    }

    // We will go through the grid column by column:
    for(int x = 0; x < grid.length; x++) {
        // this will be called once for every char
        // so just replace spaces in the grid in this column
        // by "*" if it's a row (value of y) <= the amount
        // of chars times the factor
        for(int y = 0; y < grid[x].length; y++) {
            if(y <= charCount[x] * factor) {
                grid[x][y] = "*";
            }
        }
    }

    // print the grid row by row (think of it upside down, (0,0) is the upper left point
    // so we start with the last (the no of elements in the array minus 1, counting from 0)
    System.out.println("^");
    for(int y = grid[0].length - 1; y >= 0; y--) {
        System.out.print("|");
        for(int x = 0; x < grid.length; x++) {
            System.out.print(grid[x][y]);
        }
        // finish the line:
        System.out.println();
    }
    // draw the bottom line:
    System.out.println("------->");
    System.out.println(" abcde");