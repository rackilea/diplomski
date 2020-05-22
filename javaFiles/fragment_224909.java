import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;

import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.ss.util.CellUtil;
import org.apache.poi.ss.util.PropertyTemplate;

import java.util.Map;
import java.util.HashMap;

public class CreateExcelCellStyles {

 public static CellStyle getPreferredCellStyle(Cell cell) {
  // a method to get the preferred cell style for a cell
  // this is either the already applied cell style
  // or if that not present, then the row style (default cell style for this row)
  // or if that not present, then the column style (default cell style for this column)
  CellStyle cellStyle = cell.getCellStyle();
  if (cellStyle.getIndex() == 0) cellStyle = cell.getRow().getRowStyle();
  if (cellStyle == null) cellStyle = cell.getSheet().getColumnStyle(cell.getColumnIndex());
  if (cellStyle == null) cellStyle = cell.getCellStyle();
  return cellStyle;
 }

 public static void main(String[] args) throws Exception {

  //the data
  Object[][] data = new Object[][]{
   {null, "Returns", "Benchmark 1", null, null, null, "Benchmark 2", null, null, null, "Benchmark 3", null, null, null},
   {null, null, "PME Plus", null, null, "Direct", "PME Plus", null, null, "Direct", "PME Plus", null, null, "Direct"}, 
   {null, null, "PME IRR", "IRR", "KS PME", "Alpha", "PME IRR", "IRR", "KS PME", "Alpha", "PME IRR", "IRR", "KS PME", "Alpha"}, 
   {"1 Year", .17, .162, .162, 1.01, .007, .191, .191, .99, -.018, .192, .192, .99, -.018}, 
   {"3 Year", null, null, null, null, null, null, null, null, null, null, null, null, null}, 
   {"5 Year", null, null, null, null, null, null, null, null, null, null, null, null, null}, 
   {"10 Year", null, null, null, null, null, null, null, null, null, null, null, null, null}, 
   {"20 Year", .103, .051, .059, 1.17, .048, .071, .074, 1.11, .03, .062, .066, 1.14, .037}, 
   {"Since Inception", .109, .062, .066, 1.15, .041, .079, .08, 1.10, .027, .073, .074, 1.12, .031}, 
  };

  //we need PropertyTemplate later
  PropertyTemplate propertyTemplate = new PropertyTemplate();

  //we need properties map for cell styles later
  Map<String, Object> properties;

  //creating workbook
  Workbook workbook = new XSSFWorkbook();

  //we need DataFormat later
  DataFormat format = workbook.createDataFormat();

  //creating default font
  Font defaultFont = workbook.createFont();
  defaultFont.setFontName("Calibri");
  defaultFont.setFontHeightInPoints((short)12);

  //we need font in bold and white for headings
  Font defaultFontWhite = workbook.createFont();
  defaultFontWhite.setFontName("Calibri");
  defaultFontWhite.setFontHeightInPoints((short)12);
  defaultFontWhite.setBold(true);
  defaultFontWhite.setColor(IndexedColors.WHITE.getIndex());

  //creating default cell style having default font
  CellStyle defaultCellStyle = workbook.createCellStyle();
  defaultCellStyle.setFont(defaultFont);

  //we need percent style for numbers later
  CellStyle percent = workbook.createCellStyle();
  percent.cloneStyleFrom(defaultCellStyle);
  percent.setDataFormat(format.getFormat("0.0%"));
  percent.setAlignment(HorizontalAlignment.CENTER);

  //we need user defined number style having unit "x" for numbers later
  CellStyle doubleX = workbook.createCellStyle();
  doubleX.cloneStyleFrom(defaultCellStyle);
  doubleX.setDataFormat(format.getFormat("0.00\\x"));
  doubleX.setAlignment(HorizontalAlignment.CENTER);

  //creating sheet
  Sheet sheet = workbook.createSheet();

  //set default column styles
  sheet.setDefaultColumnStyle(0, defaultCellStyle); //first column A = default
  for (int c = 1; c < 14; c++) sheet.setDefaultColumnStyle(c, percent); //columns B to N = percent; some will be overridden later
  sheet.setDefaultColumnStyle(4, doubleX); //column E = user defined number style having unit "x"
  sheet.setDefaultColumnStyle(8, doubleX); //column I = user defined number style having unit "x"
  sheet.setDefaultColumnStyle(12, doubleX); //column M = user defined number style having unit "x"

  //put data in sheet
  int r = 0;
  for (Object[] rowdata : data) {
   Row row = sheet.createRow(r++);
   int c = 0;
   for (Object celldata : rowdata) {
    Cell cell = row.createCell(c++);
    if (celldata instanceof String) cell.setCellValue((String)celldata);
    else if (celldata instanceof Double) cell.setCellValue((Double)celldata);
    cell.setCellStyle(getPreferredCellStyle(cell)); //get preferred cell style from column style
   }
  }

  //add merged regions
  sheet.addMergedRegion(new CellRangeAddress(0, 0, 2, 5));
  sheet.addMergedRegion(new CellRangeAddress(0, 0, 6, 9));
  sheet.addMergedRegion(new CellRangeAddress(0, 0, 10, 13));
  sheet.addMergedRegion(new CellRangeAddress(1, 1, 2, 4));
  sheet.addMergedRegion(new CellRangeAddress(1, 1, 6, 8));
  sheet.addMergedRegion(new CellRangeAddress(1, 1, 10, 12));

  sheet.addMergedRegion(new CellRangeAddress(0, 2, 0, 0));
  CellUtil.setVerticalAlignment(CellUtil.getCell(CellUtil.getRow(0, sheet), 0), VerticalAlignment.CENTER);
  sheet.addMergedRegion(new CellRangeAddress(0, 2, 1, 1));
  CellUtil.setVerticalAlignment(CellUtil.getCell(CellUtil.getRow(0, sheet), 1), VerticalAlignment.CENTER);

  //styling the table headings (rows 1 to 3)
  for (int rw = 0; rw < 3; rw++) {
   Row row = sheet.getRow(rw);
   for (int c = 0; c < 14; c++) {
    properties = new HashMap<String, Object>();
    properties.put(CellUtil.FILL_PATTERN, FillPatternType.SOLID_FOREGROUND);
    properties.put(CellUtil.FILL_FOREGROUND_COLOR, IndexedColors.GREY_50_PERCENT.getIndex()); //do using only IndexedColors for fills
    //properties.put(CellUtil.FONT, defaultFontWhite.getIndex()); //up to apache poi 3.17
    properties.put(CellUtil.FONT, defaultFontWhite.getIndexAsInt()); //since apache poi 4.0.0
    CellUtil.setCellStyleProperties(CellUtil.getCell(row, c), properties); //do using CellUtil for **add** new properties to already applied cell styles
   }
  }
  propertyTemplate.drawBorders(new CellRangeAddress(0, 2, 0, 13), BorderStyle.MEDIUM, BorderExtent.ALL); //since we have merged regions we can simply drawing all borders here

  //styling the table body (rows 4 to 9)
  for (int rw = 3; rw < 9; rw++) {
   Row row = sheet.getRow(rw);

   properties = new HashMap<String, Object>();
   properties.put(CellUtil.FILL_PATTERN, FillPatternType.SOLID_FOREGROUND);
   properties.put(CellUtil.FILL_FOREGROUND_COLOR, IndexedColors.LEMON_CHIFFON.getIndex());
   CellUtil.setCellStyleProperties(CellUtil.getCell(row, 0), properties); //column A

   properties = new HashMap<String, Object>();
   properties.put(CellUtil.FILL_PATTERN, FillPatternType.SOLID_FOREGROUND);
   properties.put(CellUtil.FILL_FOREGROUND_COLOR, IndexedColors.PALE_BLUE.getIndex());
   CellUtil.setCellStyleProperties(CellUtil.getCell(row, 1), properties); //column B

   for (int c = 2; c < 6; c++) {
    properties = new HashMap<String, Object>();
    properties.put(CellUtil.FILL_PATTERN, FillPatternType.SOLID_FOREGROUND);
    properties.put(CellUtil.FILL_FOREGROUND_COLOR, IndexedColors.LIGHT_GREEN.getIndex());
    CellUtil.setCellStyleProperties(CellUtil.getCell(row, c), properties); //columns C:F
   }
   for (int c = 6; c < 10; c++) {
    properties = new HashMap<String, Object>();
    properties.put(CellUtil.FILL_PATTERN, FillPatternType.SOLID_FOREGROUND);
    properties.put(CellUtil.FILL_FOREGROUND_COLOR, IndexedColors.LIGHT_ORANGE.getIndex());
    CellUtil.setCellStyleProperties(CellUtil.getCell(row, c), properties); //columns G:J
   }
   for (int c = 10; c < 14; c++) {
    properties = new HashMap<String, Object>();
    properties.put(CellUtil.FILL_PATTERN, FillPatternType.SOLID_FOREGROUND);
    properties.put(CellUtil.FILL_FOREGROUND_COLOR, IndexedColors.LIGHT_CORNFLOWER_BLUE.getIndex());
    CellUtil.setCellStyleProperties(CellUtil.getCell(row, c), properties); //columns K:N
   }
  }
  propertyTemplate.drawBorders(new CellRangeAddress(3, 8, 0, 0), BorderStyle.MEDIUM, BorderExtent.OUTSIDE); //outside border around A4:A9
  propertyTemplate.drawBorders(new CellRangeAddress(3, 8, 1, 1), BorderStyle.MEDIUM, BorderExtent.OUTSIDE); //outside border around B4:B9
  propertyTemplate.drawBorders(new CellRangeAddress(3, 8, 2, 5), BorderStyle.MEDIUM, BorderExtent.OUTSIDE); //outside border around C4:F9
  propertyTemplate.drawBorders(new CellRangeAddress(3, 8, 6, 9), BorderStyle.MEDIUM, BorderExtent.OUTSIDE); //outside border around G4:J9
  propertyTemplate.drawBorders(new CellRangeAddress(3, 8, 10, 13), BorderStyle.MEDIUM, BorderExtent.OUTSIDE); //outside border around K4:N9

  //apply the PropertyTemplate borders
  propertyTemplate.applyBorders(sheet);

  //resizing the columns A:N
  for (int c = 0; c < 14; c++) sheet.autoSizeColumn(c, true);

  //writing the result
  FileOutputStream out = new FileOutputStream("CreateExcelCellStyles.xlsx");
  workbook.write(out);
  out.close();
  workbook.close();

 }

}