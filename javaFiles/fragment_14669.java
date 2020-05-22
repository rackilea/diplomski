import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileOutputStream;

import javax.swing.JTable;
import javax.swing.table.TableModel;

class WriteJTableToExcel {

 static void exportToExcel(JTable table, String filePath) throws Exception {
  TableModel model = table.getModel();
  Workbook workbook = new XSSFWorkbook();
  Sheet sheet = workbook.createSheet();
  Row row;
  Cell cell;

  // write the column headers
  row = sheet.createRow(0);
  for (int c = 0; c < model.getColumnCount(); c++) {
   cell = row.createCell(c);
   cell.setCellValue(model.getColumnName(c));
  }

  // write the data rows
  for (int r = 0; r < model.getRowCount(); r++) {
   row = sheet.createRow(r+1);
   for (int c = 0; c < model.getColumnCount(); c++) {
    cell = row.createCell(c);
    Object value = model.getValueAt(r, c);
    if (value instanceof String) {
     cell.setCellValue((String)value);
    } else if (value instanceof Double) {
     cell.setCellValue((Double)value);
    }
   }
  }

  FileOutputStream out = new FileOutputStream(filePath);
  workbook.write(out);
  out.close();
  workbook.close();

 }

 public static void main(String[] args) throws Exception {

  Object columnNames[] = {"Name", "Amount", "Factor"};
  Object rowData[][] = {
   {"Bob", 12.0, 3.0},
   {"Alice", 34.0, 2.5},
   {"Jack", 56.0, 2.0},
   {"John", 78.0, 1.5}
  };
  JTable table = new JTable(rowData, columnNames);

  exportToExcel(table, "./Excel.xlsx");

 }
}