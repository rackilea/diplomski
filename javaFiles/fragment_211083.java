path = symbol.charAt(0); // <-- this is erroneous
maze[i][j] = symbol.charAt(j);
if (maze[i][j] == path) {
  maze[i][j] = 1;
} else {
  maze[i][j] = 0;
}