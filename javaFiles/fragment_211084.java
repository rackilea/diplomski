public int[][] readFile(String fileName) throws IOException {
  readFile = new Scanner(new File(fileName));

  info = readFile.nextLine();
  rowCol = info.split(" ", 2);
  row = Integer.parseInt(rowCol[0]);
  col = Integer.parseInt(rowCol[1]);
  maze = new int[row][col];
  System.out.println("# of rows: " + row + " # of col: " + col);

  int row = 0;

  while (readFile.hasNextLine()) {
    String symbol = readFile.nextLine();

    if (row == 0) {
      path = symbol.charAt(0);
    }

    for (int j = 0; j < col; j++) {
      maze[row][j] = symbol.charAt(j);
      if (maze[row][j] == path) {
        maze[row][j] = 1;
      } else {
        maze[row][j] = 0;
      }
      System.out.println("Path coord = (" + row + " , " + j
          + ") Value at coord = " + maze[row][j]);

    }// for j

    row++;

  }// while
  readFile.close();
  return maze;
}