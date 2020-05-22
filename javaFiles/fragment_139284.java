import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.util.*;

public class CreateExcelCellFillColor2 {

 public static void main(String[] args) throws Exception {
  //Workbook workbook = new HSSFWorkbook(); 
  Workbook workbook = new XSSFWorkbook(); 

  // Create a blank sheet 
  Sheet sheet = workbook.createSheet("student Details"); 

  // Create header CellStyle
  Font headerFont = workbook.createFont();
  headerFont.setColor(IndexedColors.WHITE.index);
  CellStyle headerCellStyle = sheet.getWorkbook().createCellStyle();
  // fill foreground color ...
  headerCellStyle.setFillForegroundColor(IndexedColors.GREY_50_PERCENT.index);
  // and solid fill pattern produces solid grey cell fill
  headerCellStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
  headerCellStyle.setFont(headerFont);

  // This data needs to be written (Object[]) 
  Map<String, Object[]> data = new TreeMap<String, Object[]>(); 
  data.put("1", new Object[]{ "ID", "NAME", "LASTNAME" }); 
  data.put("2", new Object[]{ 1, "Pankaj", "Kumar" }); 
  data.put("3", new Object[]{ 2, "Prakashni", "Yadav" }); 
  data.put("4", new Object[]{ 3, "Ayan", "Mondal" }); 
  data.put("5", new Object[]{ 4, "Virat", "kohli" }); 

  // Iterate over data and write to sheet 
  Set<String> keyset = data.keySet(); 
  int rownum = 0; 
  for (String key : keyset) { 
   // this creates a new row in the sheet 
   Row row = sheet.createRow(rownum++); 
   Object[] objArr = data.get(key); 
   int cellnum = 0; 
   for (Object obj : objArr) { 
    // this line creates a cell in the next column of that row 
    Cell cell = row.createCell(cellnum++); 
    // if rownum is 1 (first row was created before) then set header CellStyle
    if (rownum == 1) cell.setCellStyle(headerCellStyle);
    if (obj instanceof String) 
     cell.setCellValue((String)obj); 
    else if (obj instanceof Integer) 
     cell.setCellValue((Integer)obj); 
   } 
  } 

  for (int c = 0; c < 3; c++) {
   sheet.autoSizeColumn(c);
  }

  FileOutputStream out = null;
  if (workbook instanceof HSSFWorkbook) {
   out = new FileOutputStream("CreateExcelCellFillColor2.xls");
  } else if (workbook instanceof XSSFWorkbook) {
   out = new FileOutputStream("CreateExcelCellFillColor2.xlsx");
  }
  workbook.write(out);
  out.close();
  workbook.close();
 }
}