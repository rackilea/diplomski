import org.apache.poi.ss.SpreadsheetVersion;
import org.apache.poi.ss.usermodel.DataConsolidateFunction;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.AreaReference;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.ss.util.CellReference;
import org.apache.poi.xssf.usermodel.*;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.*;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import static org.openxmlformats.schemas.spreadsheetml.x2006.main.STShowDataAs.PERCENT_OF_ROW;

public class ReportGenerator {
  public static void main(String[] args) throws IOException {
    Workbook wb = new XSSFWorkbook();
    String[][] data = new String[][] { 
      { "group1", "type", "BOA", "Month", "code", "uuid" },
      { "COS1", "type1", "Y", "2017-01", "AC2", "23-2214-232-1" },
      { "COS1", "type2", "N", "2017-01", "A3C", "23-2214-232-2" },
      { "COS2", "type1", "Y", "2018-01", "A3C", "23-2214-232-3" },
      { "COS1", "type2", "Y", "2018-01", "A3C", "23-2214-232-4" },
      { "COS1", "type1", "N/A", "2017-01", "A2C", "23-2214-232-5" },
      { "COS1", "type2", "Y", "2017-01", "A2C", "23-2214-232-6" },
      { "COS1", "type1", "N", "2018-01", "A2C", "23-2214-232-7" },
      { "COS1", "type2", "Y", "2018-01", "A2C", "23-2214-232-8" }
    };

    XSSFSheet sheet = (XSSFSheet) wb.createSheet("data");
    XSSFSheet pivot = (XSSFSheet) wb.createSheet("summary");
    XSSFRow row;
    XSSFCell cell;
    for (int r = 0; r < data.length; r++) {
      row = sheet.createRow(r);
      String[] rowData = data[r];
      for (int c = 0; c < rowData.length; c++) {
        cell = row.createCell(c);
        cell.setCellValue(rowData[c]);
      }
    }

    AreaReference areaReference = new AreaReference(
    new CellReference(0,0),
    new CellReference(data.length-1, data[0].length-1),
    SpreadsheetVersion.EXCEL2007);

    XSSFTable table = sheet.createTable(areaReference);
    table.setName("Table1");
    table.setDisplayName("Table1");
    table.getCTTable().addNewTableStyleInfo();
    XSSFTableStyleInfo style = (XSSFTableStyleInfo) table.getStyle();
    style.setName("TableStyleMedium2");
    style.setShowColumnStripes(false);
    style.setShowRowStripes(true);
    table.getCTTable().addNewAutoFilter().setRef(areaReference.formatAsString()); // set AutoFilter in table

    //CellRangeAddress c = new CellRangeAddress(0, 0, 0, 5);
    //sheet.setAutoFilter(c); // do **not** set AutoFilter in sheet since this range is in a table

    XSSFPivotTable pivotTable = pivot.createPivotTable(areaReference , new CellReference("A1"), sheet);
    pivotTable.addRowLabel(3);
    pivotTable.addRowLabel(0);
    pivotTable.addRowLabel(4);

    //pivotTable.getCTPivotTableDefinition().getPivotFields().getPivotFieldArray(0).setOutline(false); // don't do this
    pivotTable.getCTPivotTableDefinition().setColGrandTotals(false);
    // pivotTable.getCTPivotTableDefinition().setOutline(false);
    pivotTable.getCTPivotTableDefinition().setColHeaderCaption("BOA");
    pivotTable.getCTPivotTableDefinition().setRowHeaderCaption("Month");

    // switch from compact layout to outline layout
    pivotTable.getCTPivotTableDefinition().setCompact(false);
    pivotTable.getCTPivotTableDefinition().setCompactData(false);
    pivotTable.getCTPivotTableDefinition().setOutline(true);
    pivotTable.getCTPivotTableDefinition().setOutlineData(true);

    pivotTable.addColumnLabel(DataConsolidateFunction.COUNT, 5, "Count of SVVD");
    pivotTable.addDataColumn(2, true);
    pivotTable.addColLabel(2);
    pivotTable.addReportFilter(1);
    List<CTDataField> ctDataFields = pivotTable.getCTPivotTableDefinition().getDataFields().getDataFieldList();
    for (CTDataField ctDataField : ctDataFields) {
      ctDataField.setShowDataAs(PERCENT_OF_ROW);
    }
    for (CTPivotField ctPivotField : pivotTable.getCTPivotTableDefinition().getPivotFields().getPivotFieldList()) {
      ctPivotField.setSubtotalTop(true);
      ctPivotField.setCompact(false);
    }
    pivotTable.getCTPivotTableDefinition().getPivotTableStyleInfo().setName("PivotStyleMedium7");

    sheet.setSelected(false);
    wb.setActiveSheet(1);

    FileOutputStream fileOut = new FileOutputStream("pivotsample.xlsx");
    wb.write(fileOut);
    wb.close();
  }
}