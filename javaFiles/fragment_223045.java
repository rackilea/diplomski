for (RowValue row : results.rowKeySet()) {
  // Only iterate over the columns that actually have values for this row
  for (Data d : results.row(row).keySet()) {
    System.out.println(results.get(row, d));
  }
}