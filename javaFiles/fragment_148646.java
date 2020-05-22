public static void mazeBuild() {
    maze.maze = new String[maze.rows][maze.columns]; // <-- this one!

    for(int x = 0; x < maze.rows; x++) { // <-- this loop tries to
        for(int y = 0; y < maze.columns; y++) { // put values in your
            maze.maze[x][y]= ".";               // maze.maze (2D String array)
            System.out.print(maze.maze[x][y]);
    }
    System.out.println();
}