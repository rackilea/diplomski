int holes = 0;
for (int x = 1; x < newGrid.length; x++) {
    for (int y = 1; y < newGrid[x].length; y++) {
        if (newGrid[x][y] == '-') {
            ++holes;
            floodFill(x, y);
        }
    }
}
System.out.println("The file had " + holes + " cancer spots in it");