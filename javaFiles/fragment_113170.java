int evenRowCount = 0;
for (int row = 0; row < matrix.length; row++) {
    int rowCount = 0;
    for (int col = 0; col < matrix[row].length; col++){
        rowCount += matrix[row][col];
    }
    if (rowCount % 2 == 0) {
       evenRowCount++;
    }
}
System.out.println("Number of rows with an even number of 1s:" + evenRowCount);

int evenColCount = 0;
for (int col = 0; col < matrix[0].length; col++) {
    int colCount = 0;
    for (int row = 0; row < matrix.length; row++){
        colCount += matrix[row][col];
    }
    if (colCount % 2 == 0) {
       evenColCount++;
    }
}
System.out.println("Number of cols with an even number of 1s:" + evenColCount);