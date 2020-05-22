if (internalGrid[r][c] == "H" && internalGrid[r + 1][c] == "H" ) {
        System.out.println("You win!!");
        i= 10;} //i think the issue is here??
    else if (internalGrid[urow][ucol] == "X") {
        System.out.println("Hit!!");
        internalGrid[urow][ucol] = "H";
    }
    else if (internalGrid[urow][ucol] == "H") {
        System.out.println("You already hit that location");} 
    else {
        System.out.println("Miss :(");

    }