import java.io.FileOutputStream;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.ss.util.CellRangeAddress;

public class CreateExcelCellWrapText {

 public static void main(String[] args) throws Exception {
  XSSFWorkbook workbook = new XSSFWorkbook();

  CellStyle cellstyle = workbook.createCellStyle();
  cellstyle.setWrapText(true);

  Sheet sheet = workbook.createSheet();

//__________________________not merged = height is auto sized

  Row row = sheet.createRow(0);

  Cell cell = row.createCell(2);
  cell.setCellValue("String cell content\nhaving line wrap.");
  cell.setCellStyle(cellstyle);

//__________________________merged = height is not auto sized

  row = sheet.createRow(2);

  cell = row.createCell(2);
  cell.setCellValue("String cell content\nhaving line wrap.");
  cell.setCellStyle(cellstyle);

  CellRangeAddress cellRangeAddress = new CellRangeAddress(2, 2, 2, 3);
  sheet.addMergedRegion(cellRangeAddress);

//__________________________merged with calculated height

  row = sheet.createRow(4);

  String text = "String cell content\nhaving line wrap.\nIt has new line marks and then a long text without new line marks.\nFollowed by short text part.\n\n\nGreetings";

  cell = row.createCell(2);
  cell.setCellValue(text);
  cell.setCellStyle(cellstyle);

  cellRangeAddress = new CellRangeAddress(4, 4, 2, 3);
  sheet.addMergedRegion(cellRangeAddress);

  //get the column width in character widths for the merged columns
  //this is not really accurate since it only is for number glyphs: 1,2,3,4,5,6,7,8,9,0
  //in true type fonts there are glyps (., |, l, ...) which need much less width
  int colwidthinchars = (sheet.getColumnWidth(2) + sheet.getColumnWidth(3)) / 256;
System.out.println(colwidthinchars);
  //correct the colwidthinchars by a factor 5/4 (highly dependent on the language used)
  colwidthinchars = Math.round(colwidthinchars * 5f/4f);
System.out.println(colwidthinchars);

  //calculate the needed rows dependent on the text and the column width in character widths
  String[] chars = text.split("");
  int neededrows = 1;
  int counter = 0;
  for (int i = 0; i < chars.length; i++) {
   counter++;
   if (counter == colwidthinchars) {
System.out.println("new line because of charcter count");
    neededrows++;
    counter = 0;
   } else if ("\n".equals(chars[i])) {
System.out.println("new line because of new line mark");
    neededrows++;
    counter = 0;
   }
  }

System.out.println(neededrows);

  //get default row height
  float defaultrowheight = sheet.getDefaultRowHeightInPoints();
System.out.println(defaultrowheight);

  row.setHeightInPoints(neededrows * defaultrowheight);

  workbook.write(new FileOutputStream("CreateExcelCellWrapText.xlsx"));
  workbook.close();
 }
}