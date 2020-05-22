import org.apache.poi.xssf.usermodel.*;
import org.apache.poi.xssf.model.StylesTable;

import org.apache.poi.ss.usermodel.DataConsolidateFunction;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.util.AreaReference;
import org.apache.poi.ss.util.CellReference;
import org.apache.poi.ss.SpreadsheetVersion;

import java.io.FileOutputStream;

import java.util.*;

import org.openxmlformats.schemas.spreadsheetml.x2006.main.*;

public class Testpivot8 {
 public static void main(String[] args) throws Exception {
  DataFormatter formatter = new DataFormatter(Locale.US);
  XSSFWorkbook wb = new XSSFWorkbook();
  XSSFCellStyle dateStyle = wb.createCellStyle();
  dateStyle.setDataFormat(wb.createDataFormat().getFormat("mm/dd/yyyy"));

  Object[][] data = new Object[][]{
   {"AAA","BBB","CCC","DDD","EEE","FFF","GGG","HHH"}, 
   {"TOM","DUMMY","VAL",1001683,"Description1",new GregorianCalendar(2017, 3, 27),"CAT",780936.58},
   {"TOM","DUMMY","VAL",1001695,"Description2",new GregorianCalendar(2017, 3, 27),"CAT",136.28},
   {"HARRY","DUMMY1","VAL1",1001692,"Description3",new GregorianCalendar(2017, 4, 3),"CAT1",191468.21},
   {"HARRY","DUMMY1","VAL1",1001698,"Description4",new GregorianCalendar(2017, 4, 4),"CAT1",10.11}
  };

  XSSFSheet sheet = wb.createSheet("data");
  for(Object[] dataRow : data) {
   XSSFRow row = sheet.createRow(sheet.getPhysicalNumberOfRows());
   for(Object dataCell : dataRow){
    XSSFCell cell = row.createCell(row.getPhysicalNumberOfCells());
    if (dataCell instanceof String) {
     cell.setCellValue((String)dataCell);
    } else if (dataCell instanceof Double) {
     cell.setCellValue((Double)dataCell);
    } else if (dataCell instanceof Integer) {
     cell.setCellValue((Integer)dataCell);
    } else if (dataCell instanceof GregorianCalendar) {
     cell.setCellValue((GregorianCalendar)dataCell);
     cell.setCellStyle(dateStyle);
    }
   }
  }

  XSSFSheet pivot = wb.createSheet("summary");
  int rowCount = data.length;
  int colCount = data[0].length;
  AreaReference areaReference = new AreaReference(new CellReference("A1"), new CellReference(rowCount-1, colCount-1), SpreadsheetVersion.EXCEL2007);
  XSSFPivotTable pivotTable =  pivot.createPivotTable(areaReference, new CellReference("A1"), sheet);
  pivotTable.getCTPivotTableDefinition().setRowHeaderCaption("AAA");

  List<Integer> iterList = new ArrayList<Integer>();
  iterList.add(0);
  iterList.add(1);
  iterList.add(2);
  iterList.add(3);
  iterList.add(4);
  iterList.add(5);
  iterList.add(6);

  pivotTable.getCTPivotTableDefinition().setUpdatedVersion((short)6); 

  for (Integer j : iterList) {
   pivotTable.addRowLabel(j);
   TreeSet<String> uniqueItems = new java.util.TreeSet<String>();
   for (int r = areaReference.getFirstCell().getRow()+1; r < areaReference.getLastCell().getRow()+1; r++) {
    uniqueItems.add(formatter.formatCellValue(sheet.getRow(r).getCell(j)));
   }

   System.out.println(uniqueItems);

   CTPivotField ctPivotField = pivotTable.getCTPivotTableDefinition().getPivotFields().getPivotFieldArray(j);
   int i = 0;
   for (String item : uniqueItems) {
    ctPivotField.getItems().getItemArray(i).unsetT();
    ctPivotField.getItems().getItemArray(i).setX((long)i);
    pivotTable.getPivotCacheDefinition().getCTPivotCacheDefinition().getCacheFields()
     .getCacheFieldArray(j).getSharedItems().addNewS().setV(item);
    i++;
   }
   ctPivotField.setDefaultSubtotal(false);
   ctPivotField.setOutline(false);

   if (ctPivotField.getDefaultSubtotal()) i++; 
   for (int k = ctPivotField.getItems().getItemList().size()-1; k >= i; k--) {
    ctPivotField.getItems().removeItem(k);
   }
   ctPivotField.getItems().setCount(i);

   CTExtensionList extList = ctPivotField.addNewExtLst();
   String extXML = 
      "<ext uri=\"{2946ED86-A175-432a-8AC1-64E0C546D7DE}\""
    + " xmlns:x14=\"http://schemas.microsoft.com/office/spreadsheetml/2009/9/main\">"
    + "<x14:pivotField fillDownLabels=\"1\"/>"
    + "</ext>";
   org.apache.xmlbeans.XmlObject xlmObject = 
   org.apache.xmlbeans.XmlObject.Factory.parse(extXML);
   extList.set(xlmObject);
  }

  System.out.println("----end---");

  pivotTable.addColumnLabel(DataConsolidateFunction.SUM, 7, "SUM");

  // create a new custom pivot table style
  // create dxf for each needed table style type
  STTableStyleType.Enum headerRow = STTableStyleType.HEADER_ROW;
  CTDxf headerRowDxf = createDxf(true, new byte[] {(byte)255, (byte)255, (byte)255}, new byte[] {(byte)4, (byte)123, (byte)91});
  STTableStyleType.Enum totalRow = STTableStyleType.TOTAL_ROW;
  CTDxf totalRowDxf = createDxf(true, new byte[] {(byte)255, (byte)255, (byte)255}, new byte[] {(byte)4, (byte)123, (byte)91});
  STTableStyleType.Enum firstRowSubheading = STTableStyleType.FIRST_ROW_SUBHEADING;
  CTDxf firstRowSubheadingDxf = createDxf(true, null, null);
  STTableStyleType.Enum secondRowSubheading = STTableStyleType.SECOND_ROW_SUBHEADING;
  CTDxf secondRowSubheadingDxf = createDxf(true, null, null);
  // map table style types to dxf
  Map<STTableStyleType.Enum, CTDxf> typeStyles = new HashMap<STTableStyleType.Enum, CTDxf>();
  typeStyles.put(headerRow, headerRowDxf);
  typeStyles.put(totalRow, totalRowDxf);
  typeStyles.put(firstRowSubheading, firstRowSubheadingDxf);
  typeStyles.put(secondRowSubheading, secondRowSubheadingDxf);
  // 
  createPivotTableStyle(wb.getStylesSource(), "CustomPivotStyle1", typeStyles);
  pivotTable.getCTPivotTableDefinition().getPivotTableStyleInfo().setName("CustomPivotStyle1");

  sheet.setSelected(false);
  wb.setActiveSheet(wb.getSheetIndex(pivot));

  FileOutputStream fileOut = new FileOutputStream("newoutputfile.xlsx");
  wb.write(fileOut);
  fileOut.close();
  wb.close();
 }

 static CTDxf createDxf(boolean fontBold, byte[] fontRGB, byte[] fillRGB) {
  CTDxf dxf = CTDxf.Factory.newInstance();
  CTFont font = dxf.addNewFont();
  if (fontBold) font.addNewB();
  if (fontRGB != null) font.addNewColor().setRgb(fontRGB);
  if (fillRGB != null) {
   CTFill fill = dxf.addNewFill();
   fill.addNewPatternFill().addNewBgColor().setRgb(fillRGB);
  }
  return dxf;
 }

 static void createPivotTableStyle(StylesTable stylesTable, String styleName, Map<STTableStyleType.Enum, CTDxf> typeStyles) {

  // get or create table styles
  CTTableStyles tableStyles = stylesTable.getCTStylesheet().getTableStyles();
  if (tableStyles == null) tableStyles = stylesTable.getCTStylesheet().addNewTableStyles();

  // add table style named as styleName
  CTTableStyle tableStyle = tableStyles.addNewTableStyle();
  tableStyle.setName(styleName);

  // set TableStyleType styles: TableStyleType -> dxf
  for (Map.Entry<STTableStyleType.Enum, CTDxf> entry : typeStyles.entrySet()) {
    STTableStyleType.Enum type = entry.getKey();
    CTDxf typeDxf = entry.getValue();
    int dxfId = stylesTable.putDxf(typeDxf);
    CTTableStyleElement tableStyleElement = tableStyle.addNewTableStyleElement();
    tableStyleElement.setDxfId(dxfId-1);
    tableStyleElement.setType(type);
  }
 }
}