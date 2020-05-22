import java.io.*;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.*;

import org.apache.poi.ss.util.CellUtil;

import java.util.Map;
import java.util.HashMap;

public class CarefulCreateCellStyles {

 public CellStyle getPreferredCellStyle(Cell cell) {
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

 public CarefulCreateCellStyles() throws Exception {

   Workbook workbook = new XSSFWorkbook();

   // at first we are creating needed fonts
   Font defaultFont = workbook.createFont();
   defaultFont.setFontName("Arial");
   defaultFont.setFontHeightInPoints((short)14);

   Font specialfont = workbook.createFont();
   specialfont.setFontName("Courier New");
   specialfont.setFontHeightInPoints((short)18);
   specialfont.setBold(true);

   // now we are creating a default cell style which will then be applied to all cells
   CellStyle defaultCellStyle = workbook.createCellStyle();
   defaultCellStyle.setFont(defaultFont);

   // maybe sone rows need their own default cell style
   CellStyle aRowCellStyle = workbook.createCellStyle();
   aRowCellStyle.cloneStyleFrom(defaultCellStyle);
   aRowCellStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
   aRowCellStyle.setFillForegroundColor((short)3);


   Sheet sheet = workbook.createSheet("Sheet1");

   // apply default cell style as column style to all columns
   org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCol cTCol = 
      ((XSSFSheet)sheet).getCTWorksheet().getColsArray(0).addNewCol();
   cTCol.setMin(1);
   cTCol.setMax(workbook.getSpreadsheetVersion().getLastColumnIndex());
   cTCol.setWidth(20 + 0.7109375);
   cTCol.setStyle(defaultCellStyle.getIndex());

   // creating cells
   Row row = sheet.createRow(0);
   row.setRowStyle(aRowCellStyle);
   Cell cell = null;
   for (int c = 0; c  < 3; c++) {
    cell = CellUtil.createCell(row, c, "Header " + (c+1));
    // we get the preferred cell style for each cell we are creating
    cell.setCellStyle(getPreferredCellStyle(cell));
   }

   System.out.println(workbook.getNumCellStyles()); // 3 = 0(default) and 2 just created

   row = sheet.createRow(1);
   cell = CellUtil.createCell(row, 0, "centered");
   cell.setCellStyle(getPreferredCellStyle(cell));
   CellUtil.setAlignment(cell, HorizontalAlignment.CENTER);

   System.out.println(workbook.getNumCellStyles()); // 4 = 0 and 3 just created

   cell = CellUtil.createCell(row, 1, "bordered");
   cell.setCellStyle(getPreferredCellStyle(cell));
   Map<String, Object> properties = new HashMap<String, Object>();
   properties.put(CellUtil.BORDER_LEFT, BorderStyle.THICK);
   properties.put(CellUtil.BORDER_RIGHT, BorderStyle.THICK);
   properties.put(CellUtil.BORDER_TOP, BorderStyle.THICK);
   properties.put(CellUtil.BORDER_BOTTOM, BorderStyle.THICK);
   CellUtil.setCellStyleProperties(cell, properties);

   System.out.println(workbook.getNumCellStyles()); // 5 = 0 and 4 just created

   cell = CellUtil.createCell(row, 2, "other font");
   cell.setCellStyle(getPreferredCellStyle(cell));
   CellUtil.setFont(cell, specialfont);

   System.out.println(workbook.getNumCellStyles()); // 6 = 0 and 5 just created

// until now we have always created new cell styles. but from now on CellUtil will use
// already present cell styles if they matching the needed properties.

   row = sheet.createRow(2);
   cell = CellUtil.createCell(row, 0, "bordered");
   cell.setCellStyle(getPreferredCellStyle(cell));
   properties = new HashMap<String, Object>();
   properties.put(CellUtil.BORDER_LEFT, BorderStyle.THICK);
   properties.put(CellUtil.BORDER_RIGHT, BorderStyle.THICK);
   properties.put(CellUtil.BORDER_TOP, BorderStyle.THICK);
   properties.put(CellUtil.BORDER_BOTTOM, BorderStyle.THICK);
   CellUtil.setCellStyleProperties(cell, properties);

   System.out.println(workbook.getNumCellStyles()); // 6 = nothing new created

   cell = CellUtil.createCell(row, 1, "other font");
   cell.setCellStyle(getPreferredCellStyle(cell));
   CellUtil.setFont(cell, specialfont);

   System.out.println(workbook.getNumCellStyles()); // 6 = nothing new created

   cell = CellUtil.createCell(row, 2, "centered");
   cell.setCellStyle(getPreferredCellStyle(cell));
   CellUtil.setAlignment(cell, HorizontalAlignment.CENTER);

   System.out.println(workbook.getNumCellStyles()); // 6 = nothing new created

   FileOutputStream out = new FileOutputStream("CarefulCreateCellStyles.xlsx");
   workbook.write(out);
   out.close();
   workbook.close();  
 }

 public static void main(String[] args) throws Exception {
  CarefulCreateCellStyles carefulCreateCellStyles = new CarefulCreateCellStyles();
 }
}