import java.io.*;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.*;

import org.apache.poi.ss.util.*;

class CreateExcelDataValidationList {

 public static void main(String[] args) throws Exception{

   Workbook workbook = new XSSFWorkbook();  

   //create sheet for storing the list items:
   Sheet sheet = workbook.createSheet("ListSheet");
   sheet.createRow(0).createCell(0).setCellValue("SourceList");
   int r = 1;
   for (double d = 0.5; d < 3; d+=0.5) {
    sheet.createRow(r++).createCell(0).setCellValue(d);
   }
   //unselect that sheet because we will hide it later
   sheet.setSelected(false);
   //create a named range for the list contraint
   Name namedCell = workbook.createName();
   namedCell.setNameName("SourceList");
   String reference = "ListSheet!$A$2:$A$5";
   namedCell.setRefersToFormula(reference);

   //create the visible sheet
   sheet = workbook.createSheet("Sheet1");

   sheet.createRow(0).createCell(0).setCellValue("Take the ListItems from B1:");
   sheet.setActiveCell(new CellAddress("B1"));

   sheet.autoSizeColumn(0);

   //create the data validation
   DataValidationHelper dvHelper = sheet.getDataValidationHelper();
   DataValidationConstraint dvConstraint = dvHelper.createFormulaListConstraint("SourceList");
   CellRangeAddressList addressList = new CellRangeAddressList(0, 0, 1, 1);            
   DataValidation validation = dvHelper.createValidation(dvConstraint, addressList);

   sheet.addValidationData(validation);

   //hide the ListSheet
   workbook.setSheetHidden(0, true);
   //set Sheet1 active
   workbook.setActiveSheet(1);

   workbook.write(new FileOutputStream("CreateExcelDataValidationList.xlsx"));
   workbook.close();

 }
}