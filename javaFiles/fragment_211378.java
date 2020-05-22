import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import org.apache.poi.ss.util.CellRangeAddress;

import java.io.FileOutputStream;

public class ConditionalFormatting {

 public static void applyColorScale(SheetConditionalFormatting sheetCF, String region, String... colors) {
  CellRangeAddress[] regions = { CellRangeAddress.valueOf(region) };
  ConditionalFormattingRule rule = sheetCF.createConditionalFormattingColorScaleRule();
  ColorScaleFormatting csf = rule.getColorScaleFormatting();
  if (colors.length == 3) {
   csf.getThresholds()[0].setRangeType(ConditionalFormattingThreshold.RangeType.MIN);
   csf.getThresholds()[1].setRangeType(ConditionalFormattingThreshold.RangeType.PERCENTILE);
   csf.getThresholds()[1].setValue(50d);
   csf.getThresholds()[2].setRangeType(ConditionalFormattingThreshold.RangeType.MAX);
   for (int c = 0; c < 3; c++) {
    ((ExtendedColor)csf.getColors()[c]).setARGBHex(colors[c]);
   }
  } else if (colors.length == 2) {
   csf.setNumControlPoints(2);
   csf.getThresholds()[0].setRangeType(ConditionalFormattingThreshold.RangeType.MIN);
   csf.getThresholds()[1].setRangeType(ConditionalFormattingThreshold.RangeType.MAX);
   for (int c = 0; c < 2; c++) {
    ((ExtendedColor)csf.getColors()[c]).setARGBHex(colors[c]);
   }
  }

  sheetCF.addConditionalFormatting(regions, rule);
 }

 public static void main(String[] args) throws Exception {
  Workbook workbook = new XSSFWorkbook();

  Sheet sheet = workbook.createSheet("new sheet");

  for (int r = 1; r < 20; r++) {
   sheet.createRow(r).createCell(9).setCellFormula("RANDBETWEEN(-100, 100)");
   sheet.getRow(r).createCell(11).setCellFormula("RANDBETWEEN(-100, 100)");
  }

  SheetConditionalFormatting sheetCF = sheet.getSheetConditionalFormatting();

  applyColorScale(sheetCF, "J2:J21", "FFFF0000", "FFFFFF00", "FF00FF00");
  applyColorScale(sheetCF, "L2:L21", "FFFF0000", "FF00FF00");

  FileOutputStream out = new FileOutputStream("ConditionalFormatting.xlsx");
  workbook.write(out);
  out.close();
  workbook.close();

 }
}