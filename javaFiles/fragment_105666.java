int maxRow = 0;
int indexofMaxRow = 0;

for (int row = 0; row < maxRowValue.length; row++) {
    int totalOfRow = 0;
    for (int column = 0; column < maxRowValue[row].length; column++){
         if (maxRowValue[row][column] > 0) {
             totalOfRow += maxRowValue[row][column];
         } else {
             totalOfRow -= maxRowValue[row][column];
         }
     }
     if (totalOfRow > maxRow) {
         maxRow = totalOfRow;
         indexofMaxRow = row;
     }
}
System.out.println("Row " + indexofMaxRow + " has the sum of " + maxRow);
return indexofMaxRow;