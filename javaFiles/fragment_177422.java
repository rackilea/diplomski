DataFormatter fmt = new DataFormatter();
for (Row r : sheet) {
   for (Cell c : r) {
       if ("ThingToLookFor".equals(fmt.formatCellValue(cell))) {
          // Found it!
          int columnIndex = c.getColumnIndex();
          int rowNumber = c.getRowNumber();
          // Get the Excel style reference, eg C12
          String ref = ((new CellReference(rowNumber,columnIndex)).formatAsString();
       }
   }
}