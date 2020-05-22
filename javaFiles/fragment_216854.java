List<List<Object>> excelData = new ArrayList<>();

try {
   //...
   while (itr.hasNext()) {
       Row row = itr.next();
       List<Object> dataRow = new ArrayList<>();
       excelData.add(dataRow);
       Iterator<Cell> itrCell = row.cellIterator();
       while (itrCell.hasNext()) {
          Cell cell = itrCell.next();
          if (cell == null) {
               dataRow.add(null);
               continue;
          }
          switch (cell.getCellType()) {
          case Cell.CELL_TYPE_NUMERIC:
              dataRow.add(cell.getNumericCellValue());
              break;
          case Cell.CELL_TYPE_STRING:
              dataRow.add(cell.getStringCellValue());
              break;
          case Cell.CELL_TYPE_BOOLEAN:
              dataRow.add(cell.getBooleanCellValue());
              break;
          case Cell.CELL_TYPE_BLANK:
              dataRow.add("");
              break;
          default:
              dataRow.add(cell);
          }
      }
  }