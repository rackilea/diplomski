System.out.printf("Grid width %d: \"", width);
for (int r = 0; r < width; r++) {
    for (int c = 0; c < height; c++) {
        System.out.print(grid[c][r]);
    }
}

System.out.println("\"");