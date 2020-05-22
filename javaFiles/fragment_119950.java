for (i = 0; i < rows; i++) {
    for(j = 0; j < cols; j++) {
        int value = parseInt(p1.getProperty(i + "," + j); // Get the value of (i,j)
        maze[i][j] = value; // Assign the value to the maze
    }
}