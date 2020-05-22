boolean allRowsDone = true;              
currentRow++; 
while (resultSet.next()) {
    row = sheet.createRow(currentRow++); 
    for (int i = 0; i < numCols; i++) { 
        Object value = resultSet.getObject(i + 1); 
        writeCell(row, i, value, formatTypes[i]); 
     }
     if (currentRow >= 64000) {
         allRowsDone = false;
         break; 
}
// put the rest of your code here
return allRowsDone;