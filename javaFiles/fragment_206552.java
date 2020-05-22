import java.io.*;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.*;

public class CreateSheets {

 public static void main(String[] args) throws Exception {
  Workbook workbook = new XSSFWorkbook();
  Sheet masterDataSheet = workbook.createSheet("MasterData"); //first sheeet will be both active and selected
  Sheet customerAssetsSheet = workbook.createSheet("Customer Assets");
  Sheet sheet1 = workbook.createSheet("Sheet1");

  workbook.setSheetHidden(0,  true);       //hide masterDataSheet
  masterDataSheet.setSelected(false);      //unselect masterDataSheet

  workbook.setActiveSheet(1);              //sets active sheet as Customer Assets Sheet
  //customerAssetsSheet.setSelected(true); //not necessary but recommended: set Customer Assets Sheet selected

  masterDataSheet.protectSheet("12345");   // protect MasterData sheet

  FileOutputStream fileOut = new FileOutputStream("CreateSheets.xlsx");
  workbook.write(fileOut);
  fileOut.close();
  workbook.close();
 }
}