int length = poller.length;
for (int row = 0; row < length; row++) {
  int rowLength = poller[row].length;
  System.out.println("");
  for (int col = 0; col < rowLength; col++) {
    System.out.print(poller[row][col]);
  }
}