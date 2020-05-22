import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFDataBarFormatting;
import org.apache.poi.xssf.usermodel.XSSFConditionalFormattingRule;

import org.apache.poi.ss.util.CellRangeAddress;

import java.io.FileOutputStream;

import java.lang.reflect.Field;

public class ConditionalFormattingDataBars {

 public static void applyDataBars(SheetConditionalFormatting sheetCF, String region, ExtendedColor color) throws Exception {
  CellRangeAddress[] regions = { CellRangeAddress.valueOf(region) };
  ConditionalFormattingRule rule = sheetCF.createConditionalFormattingRule(color);
  DataBarFormatting dbf = rule.getDataBarFormatting();
  dbf.getMinThreshold().setRangeType(ConditionalFormattingThreshold.RangeType.NUMBER);
  dbf.getMinThreshold().setValue(0d);
  dbf.getMaxThreshold().setRangeType(ConditionalFormattingThreshold.RangeType.NUMBER);
  dbf.getMaxThreshold().setValue(100d);

  dbf.setIconOnly(true);

  dbf.setWidthMin(0); //cannot work for XSSFDataBarFormatting, see https://svn.apache.org/viewvc/poi/tags/REL_4_0_1/src/ooxml/java/org/apache/poi/xssf/usermodel/XSSFDataBarFormatting.java?view=markup#l57
  dbf.setWidthMax(100); //cannot work for XSSFDataBarFormatting, see https://svn.apache.org/viewvc/poi/tags/REL_4_0_1/src/ooxml/java/org/apache/poi/xssf/usermodel/XSSFDataBarFormatting.java?view=markup#l64

  if (dbf instanceof XSSFDataBarFormatting) {
   Field _databar = XSSFDataBarFormatting.class.getDeclaredField("_databar");
   _databar.setAccessible(true);
   org.openxmlformats.schemas.spreadsheetml.x2006.main.CTDataBar ctDataBar =
    (org.openxmlformats.schemas.spreadsheetml.x2006.main.CTDataBar)_databar.get(dbf);
   ctDataBar.setMinLength(0);
   ctDataBar.setMaxLength(100);
  }

  // use extension from x14 namespace to set data bars not using gradient color 
  if (rule instanceof XSSFConditionalFormattingRule) {
   Field _cfRule = XSSFConditionalFormattingRule.class.getDeclaredField("_cfRule");
   _cfRule.setAccessible(true);
   org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCfRule ctRule =
    (org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCfRule)_cfRule.get(rule);
   org.openxmlformats.schemas.spreadsheetml.x2006.main.CTExtensionList extList =
    ctRule.addNewExtLst();
   org.openxmlformats.schemas.spreadsheetml.x2006.main.CTExtension ext = extList.addNewExt();
   String extXML = 
      "<x14:id"
    + " xmlns:x14=\"http://schemas.microsoft.com/office/spreadsheetml/2009/9/main\">"
    + "{00000000-000E-0000-0000-000001000000}"
    + "</x14:id>";
   org.apache.xmlbeans.XmlObject xlmObject = org.apache.xmlbeans.XmlObject.Factory.parse(extXML);
   ext.set(xlmObject);
   ext.setUri("{B025F937-C7B1-47D3-B67F-A62EFF666E3E}");

   Field _sh = XSSFConditionalFormattingRule.class.getDeclaredField("_sh");
   _sh.setAccessible(true);
   XSSFSheet sheet = (XSSFSheet)_sh.get(rule);
   extList = sheet.getCTWorksheet().addNewExtLst();
   ext = extList.addNewExt();
   extXML = 
      "<x14:conditionalFormattings xmlns:x14=\"http://schemas.microsoft.com/office/spreadsheetml/2009/9/main\">"
    + "<x14:conditionalFormatting xmlns:xm=\"http://schemas.microsoft.com/office/excel/2006/main\">"
    + "<x14:cfRule type=\"dataBar\" id=\"{00000000-000E-0000-0000-000001000000}\">"
    + "<x14:dataBar minLength=\"" + 0 + "\" maxLength=\"" + 100 + "\" gradient=\"" + false + "\">"
    + "<x14:cfvo type=\"num\"><xm:f>" + 0 + "</xm:f></x14:cfvo>"
    + "<x14:cfvo type=\"num\"><xm:f>" + 100 + "</xm:f></x14:cfvo>"
    + "</x14:dataBar>"
    + "</x14:cfRule>"
    + "<xm:sqref>" + region + "</xm:sqref>"
    + "</x14:conditionalFormatting>"
    + "</x14:conditionalFormattings>";
   xlmObject = org.apache.xmlbeans.XmlObject.Factory.parse(extXML);
   ext.set(xlmObject);
   ext.setUri("{78C0D931-6437-407d-A8EE-F0AAD7539E65}");
  }

  sheetCF.addConditionalFormatting(regions, rule);
 }

 public static void main(String[] args) throws Exception {
  Workbook workbook = new XSSFWorkbook();

  Sheet sheet = workbook.createSheet("new sheet");

  double[] list = new double[]{0d, 10d, 20d, 30d, 40d, 50d, 60d, 70d, 80d, 90d, 100d};
  for (int i = 0; i < list.length; i++) {
   sheet.createRow(i+1).createCell(0).setCellValue(0d);
   sheet.getRow(i+1).createCell(1).setCellValue(list[i]);
   sheet.getRow(i+1).createCell(2).setCellValue(100d);
  }

  SheetConditionalFormatting sheetCF = sheet.getSheetConditionalFormatting();
  ExtendedColor color = workbook.getCreationHelper().createExtendedColor();
  color.setARGBHex("FF80C279");
  applyDataBars(sheetCF, "B2:B12", color);

  sheet.setColumnWidth(1, 50*256);

  FileOutputStream out = new FileOutputStream("ConditionalFormattingDataBars.xlsx");
  workbook.write(out);
  out.close();
  workbook.close();

 }
}