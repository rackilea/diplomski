void highlightMemberNames(Sheet individualSheet, String memberName) {
  Map<String, Object> properties = new HashMap<String, Object>();
  properties.put(CellUtil.FILL_PATTERN, FillPatternType.SOLID_FOREGROUND);
  properties.put(CellUtil.FILL_FOREGROUND_COLOR, IndexedColors.LIGHT_GREEN.getIndex());
  properties.put(CellUtil.ALIGNMENT, HorizontalAlignment.CENTER);
  for (Row row : individualSheet) {
   for (Cell cell : row) {
    if (cell.getCellType() == CellType.STRING && cell.getStringCellValue().equals(memberName)) {
     CellUtil.setCellStyleProperties(cell, properties); 
    }
   }
  }
 }