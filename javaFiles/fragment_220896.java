public String printMaze(char[][] maze) {
    String s = "";
    for (int i=0; i < maze.length; i++) {
        for (int j=0; j < maze[i].length; j++) {
            s += maze[i][j];
        }
        // uncomment next line if you want the maze to have rows
        // s += "\n";
    }
    return s.toString();
}