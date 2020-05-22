workbook.setMissingCellPolicy(MissingCellPolicy.RETURN_BLANK_AS_NULL);
DataFormatter fmt = new DataFormatter();

for(int sn=0; sn<workbook.getNumberOfSheets(); sn++) {
   Sheet sheet = workbook.getSheetAt(sn);
   for (int rn=sheet.getFirstRowNum(); rn<=sheet.getLastRowNum(); rn++) {
      Row row = sheet.getRow(rn);
      if (row == null) {
         // There is no data in this row, handle as needed
      } else {
         // Row "rn" has data
         for (int cn=0; cn<row.getLastCellNum(); cn++) {
            Cell cell = row.getCell(cn);
            if (cell == null) {
              // This cell is empty/blank/un-used, handle as needed
            } else {
               String cellStr = fmt.formatCell(cell);
               // Do something with the value
            }
         }
      }
   }
}