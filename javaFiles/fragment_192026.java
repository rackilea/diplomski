boolean inData = true;
while (rowIterator.hasNext() && inData) {
   row = rowIterator.next();
   if (row == null || isCellEmpty(row.getCell(2))) {
      inData = false;
   } else {
      // Use the row
   }
}