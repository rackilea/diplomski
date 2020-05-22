import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.ss.usermodel.*;

import org.apache.poi.ss.util.CellRangeAddress;

import java.io.FileOutputStream;

class ConditionalFormattingIconSet {

 public static void main(String[] args) throws Exception {

  Workbook workbook = new XSSFWorkbook();

  Sheet sheet = workbook.createSheet("Sheet1");

  CellStyle cellStyle = workbook.createCellStyle();
  cellStyle.setAlignment(HorizontalAlignment.CENTER); 
  cellStyle.setVerticalAlignment(VerticalAlignment.CENTER); 

  Cell cell = sheet.createRow(0).createCell(0);
  cell.setCellValue(-1);
  cell.setCellStyle(cellStyle);

  SheetConditionalFormatting sheetCF = sheet.getSheetConditionalFormatting();

  ConditionalFormattingRule rule = sheetCF.createConditionalFormattingRule(IconMultiStateFormatting.IconSet.GYR_3_TRAFFIC_LIGHTS);

  //rule.getMultiStateFormatting().setIconOnly(true);

  IconMultiStateFormatting iconMultiStateFormatting = rule.getMultiStateFormatting();
  ConditionalFormattingThreshold[] thresholds = iconMultiStateFormatting.getThresholds();
  if (thresholds.length == 3) {
   for (int i = 0; i < 3; i++) {
    ConditionalFormattingThreshold threshold = thresholds[i];
System.out.println(i + " : " + threshold.getRangeType()); // default 
System.out.println(i + " : " + threshold.getValue()); // default
    // changing the thresholds
    if (i == 0) {
     threshold.setValue(0d);
    } else if (i == 1) {
     threshold.setRangeType(ConditionalFormattingThreshold.RangeType.NUMBER);
     threshold.setValue(0d);
    } else if (i == 2) {
     threshold.setRangeType(ConditionalFormattingThreshold.RangeType.NUMBER);
     threshold.setValue(1d);
    }
   }
  }

  ConditionalFormattingRule [] cfRules = {rule};

  CellRangeAddress[] regions = {CellRangeAddress.valueOf("A1:A1")};

  sheetCF.addConditionalFormatting(regions, cfRules);

  FileOutputStream fileOut = new FileOutputStream("ConditionalFormattingIconSet.xlsx");
  workbook.write(fileOut);
  fileOut.close();

 }
}