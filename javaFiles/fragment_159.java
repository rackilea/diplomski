import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.util.SheetUtil;

import java.io.*;

class ExcelToHTMLColspan {

 public static void main(String[] args) throws Exception{

  Workbook workbook = WorkbookFactory.create(new FileInputStream("Test.xlsx"));

  DataFormatter dataFormatter = new DataFormatter();

  int defaultCharWidth = SheetUtil.getDefaultCharWidth(workbook);

  int lastColumnToExport = 5; // column E

  Sheet sheet = workbook.getSheetAt(0);

  Row row;
  Cell cell;
  String cellValue;

  StringBuilder tableHTML = new StringBuilder();

  tableHTML.append("<TABLE>");
  tableHTML.append("<COLGROUP>");
  for (int c = 0; c < lastColumnToExport; c++) {
   long columnWidthPx = Math.round(sheet.getColumnWidthInPixels(c));
   tableHTML.append("<COL width=\"" + columnWidthPx + "\"/>");
  }
  tableHTML.append("</COLGROUP>");

  for (int r = 0; r <= sheet.getLastRowNum(); r++) {
   row = sheet.getRow(r); if (row == null) row = sheet.createRow(r);
   long rowHeightPx = Math.round(row.getHeightInPoints() * 92f / 72f);
   tableHTML.append("<TR height=\"" + rowHeightPx + "\">");
   int c = 0;
   while(c < lastColumnToExport) {
    tableHTML.append("<TD");
    cell = row.getCell(c); if (cell == null) cell = row.createCell(c);
    cellValue = dataFormatter.formatCellValue(cell);
    double cellValueWidth = SheetUtil.getCellWidth(cell, defaultCharWidth, dataFormatter, false);
    int neededColunmnWidth = (int)cellValueWidth*256;
    int columnWidth = sheet.getColumnWidth(c);
    if (columnWidth < neededColunmnWidth) {
     int colSpan = 1;
     while(columnWidth < neededColunmnWidth) {
      colSpan++;
      c++;
      columnWidth += sheet.getColumnWidth(c);
     } 
     tableHTML.append(" colspan=\"" + colSpan + "\""  + ">" + cellValue);
     c++;
    } else {
     tableHTML.append(">" + cellValue);
     c++;
    }
    tableHTML.append("</TD>");
   }
   tableHTML.append("</TR>");
  }

  tableHTML.append("</TABLE>");

  workbook.close();

System.out.println(tableHTML.toString());

  //creating a sample HTML file 
  String encoding = "UTF-8";
  FileOutputStream fos = new FileOutputStream("result.html");
  OutputStreamWriter writer = new OutputStreamWriter(fos, encoding);
  writer.write("<!DOCTYPE html>\n");
  writer.write("<html lang=\"en\">");
  writer.write("<head>");
  writer.write("<meta charset=\"utf-8\"/>");
  writer.write("<style>");
  writer.write("table {border-collapse: collapse; table-layout: fixed;}");
  writer.write("table, tr, td {border: 1px solid black;}");
  writer.write("td {font: 11pt Calibri, arial, sans-serif;}");
  writer.write("</style>");
  writer.write("</head>");
  writer.write("<body>");

  writer.write(tableHTML.toString());

  writer.write("</body>");
  writer.write("</html>");
  writer.close();

  java.awt.Desktop.getDesktop().browse(new File("result.html").toURI());

 }
}