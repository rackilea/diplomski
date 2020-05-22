Cell[][] cellArray = new Cell[inputArray.length][inputArray[0].length]();
for (int i=0; i<inputArray.length; i++) {
  for (int j=0; j<inputArray[0].length; j++) {
    Cell cell = new Cell();
    if (inputArray[i][j] == 0) {
      // Set cell attributes for 0 values
    } else {
      // Set cell attributes for 1 values
    }
    cellArray[i][j] = cell;
  }
}