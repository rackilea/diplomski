if (sheet == null) {
        return;
  }

  int rows = sheet.getPhysicalNumberOfRows();
  for(int r = 1; r<rows; r++) {
        HSSFRow row = sheet.getRow(r);
        if (row != null) {
             int cols = row.getLastCellNum();

             for(int c=0; c < cols; c++) {
                 HSSFCell cell = row.getCell(c, Row.CREATE_NULL_AS_BLANK);

                 if (cell != null) {
                    switch(cell.getColumnIndex())    {
                         case 0:
                         case 1:
                         case ...:

                     }
                 }
             }
      }
 }