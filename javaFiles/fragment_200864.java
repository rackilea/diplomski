...
  for (int row = 0; row < 4; row++) {
   for (int col = 0; col < 9; col++) {
    //table.getRow(row).getCell(col).setText("row " + row + ", col " + col);
    if (row < 3) { // header rows
     table.getRow(row).getCell(col).setColor("D9D9D9"); // header rows color
     table.getRow(row).setRepeatHeader(true); // header rows shall repeat on new pages
    }
   }
  }
...