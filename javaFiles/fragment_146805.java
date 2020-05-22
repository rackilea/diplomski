import java.io.InputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import org.apache.poi.util.IOUtils;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.ClientAnchor;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.util.Units;
import org.apache.poi.xssf.usermodel.*;

class CreateExcelPictures {

 static String excelPath = "ExcelWithPictures.xlsx";
 static String[][] data = new String[][]{
  new String[]{"Image", "Text", "Type"},
  new String[]{"", "One", "One and Three"},
  new String[]{"", "Two", "Two only"},
  new String[]{"", "Three", "One and Three"}
 };
 static String[] pictureFileNames = new String[]{"one.png", "two.png", "three.png"};
 static int pictureWidthPx = 30;
 static int pictureHeightPx = 25;
 static XSSFWorkbook workbook;
 static XSSFSheet sheet;

 static void addImage(int col1, int row1, int col2, int row2, 
  int dx1, int dy1, int dx2, int dy2,
  String imageFileName, ClientAnchor.AnchorType anchorType) throws Exception {

  InputStream imageInputStream = new FileInputStream(imageFileName);
  byte[] bytes = IOUtils.toByteArray(imageInputStream);
  int pictureId = workbook.addPicture(bytes, Workbook.PICTURE_TYPE_PNG);
  imageInputStream .close();

  XSSFClientAnchor anchor = workbook.getCreationHelper().createClientAnchor();
  anchor.setAnchorType(anchorType);
  // set Col1, Dx1, Row1, Dy1, Col2, Dx2, Row2, Dy2
  // only this determines the picture's size then
  anchor.setCol1(col1);
  anchor.setDx1(dx1);
  anchor.setRow1(row1);
  anchor.setDy1(dy1);
  anchor.setCol2(col2);
  anchor.setDx2(dx2);
  anchor.setRow2(row2);
  anchor.setDy2(dy2);

  XSSFDrawing drawing = sheet.createDrawingPatriarch();

  XSSFPicture picture = drawing.createPicture(anchor, pictureId);

 }

 public static void main(String args[]) throws Exception {

  workbook = new XSSFWorkbook();
  sheet = workbook.createSheet();
  int r = 0;
  for (String[] rowData : data) {
   XSSFRow row = sheet.createRow(r);
   int c = 0;
   for (String cellData : rowData) {
    XSSFCell cell = row.createCell(c++);
    cell.setCellValue(cellData);
   }
   if (r > 0) {
    float rowHeight = (float)Units.pixelToPoints(pictureHeightPx); // picture's height must fit into row height
    row.setHeightInPoints(rowHeight);
    addImage(0, r, 0, r, /*all fits in one cell*/
     /*Dx1 = 0 and Dy1 = 0, picture's top left edge starts on top left of the cell*/
     Units.pixelToEMU(0), Units.pixelToEMU(0), 
     /*Dx2 is picture's width and Dy2 is picture's height, picture's bottom right edge ends on that point into the cell*/
     Units.pixelToEMU(pictureWidthPx), Units.pixelToEMU(pictureHeightPx),
     pictureFileNames[r-1], ClientAnchor.AnchorType.MOVE_AND_RESIZE);
   }
   r++; 
  }

  sheet.setColumnWidth(2, 15*256);
  sheet.setAutoFilter(new CellRangeAddress(0, 3, 0, 2));

  FileOutputStream fos = new FileOutputStream(excelPath);
  workbook.write(fos);
  fos.close();
  workbook.close();

 }
}