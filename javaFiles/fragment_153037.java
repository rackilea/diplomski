public class SellUpdateModel extends AbstractTableModel {
 private final String[] tableHeaders = {"X", "Y", "Z"};


 @Override
 public String getColumnName(int columnIndex) {
  return tableHeaders[columnIndex];
 }
}