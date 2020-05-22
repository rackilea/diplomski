Vector<Vector<Float>> data = new Vector<>();
for (int rowIdx = 0; rowIdx < ROWS_COUNT; rowIdx++) {
  Vector<Float> row = new Vector<>();
  data.add(row);
  for (int colIdx = 0; colIdx < COL_COUNTS; colIdx++) {
    row.add(1.0f);
  }
}