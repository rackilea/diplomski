int columnWanted = 3;
List<Cell> cells = new ArrayList<Cell>();

for (Row row : sheet) {
   Cell c = row.getCell(columnWanted);
   if (c == null || c.getCellType == Cell.CELL_TYPE_BLANK) {
      // Nothing in the cell in this row, skip it
   } else {
      cells.add(c);
   }
}

// Now use the cells array