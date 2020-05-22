import org.apache.poi.xssf.usermodel.*;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.util.*;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.FileInputStream;
import java.io.InputStream;

import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWorksheet;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSheetData;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTRow;

import java.util.List;

class Testfile {

 public static void main(String[] args) {
  try {

   InputStream inp = new FileInputStream("testfile.xlsx");
   Workbook wb = WorkbookFactory.create(inp);

   Sheet sheet = wb.getSheetAt(0);

   System.out.println(sheet.getFirstRowNum());

   CTWorksheet ctWorksheet = ((XSSFSheet)sheet).getCTWorksheet();

   CTSheetData ctSheetData = ctWorksheet.getSheetData();

   List<CTRow> ctRowList = ctSheetData.getRowList();

   Row row = null;
   Cell[] cell = new Cell[2];

   for (CTRow ctRow : ctRowList) {
    row = new MyRow(ctRow, (XSSFSheet)sheet);
    cell[0] = row.getCell(0);
    cell[1] = row.getCell(1);
    if (cell[0] != null && cell[1] != null && cell[0].toString() != "" && cell[1].toString() != "") 
       System.out.println(cell[0].toString()+"\t"+cell[1].toString());
   }

  } catch (InvalidFormatException ifex) {
  } catch (FileNotFoundException fnfex) {
  } catch (IOException ioex) {
  }
 }
}

class MyRow extends XSSFRow {
 MyRow(org.openxmlformats.schemas.spreadsheetml.x2006.main.CTRow row, XSSFSheet sheet) {
  super(row, sheet);
 }
}