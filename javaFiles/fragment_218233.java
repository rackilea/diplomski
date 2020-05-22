import java.io.*;

import org.apache.poi.xwpf.usermodel.*;

import org.apache.poi.ss.util.*;
import org.apache.poi.util.Units;

import org.apache.poi.xddf.usermodel.*;
import org.apache.poi.xddf.usermodel.chart.*;

import org.apache.poi.xssf.usermodel.*;

public class CreateWordXDDFChart {

 // methode to set title in the data sheet without creating a Table but using the sheet data only
 // creating a Table is not really necessary
 static CellReference setTitleInDataSheet(XDDFChart chart, String title, int column) throws Exception {
  XSSFWorkbook workbook = chart.getWorkbook();
  XSSFSheet sheet = workbook.getSheetAt(0);
  XSSFRow row = sheet.getRow(0); if (row == null) row = sheet.createRow(0);
  XSSFCell cell = row.getCell(column); if (cell == null) cell = row.createCell(column);
  cell.setCellValue(title);
  return new CellReference(sheet.getSheetName(), 0, column, true, true);
 }

 // methode to fill a series data into the underlying sheet
 static void fillSheet(XDDFChart chart, XDDFDataSource<?> categoryData, XDDFNumericalDataSource<?> valuesData) throws Exception {
  XSSFWorkbook workbook = chart.getWorkbook();
  XSSFSheet sheet = workbook.getSheetAt(0);
  int numOfPoints = categoryData.getPointCount();
  for (int i = 0; i < numOfPoints; i++) {
   XSSFRow row = sheet.getRow(i + 1); if (row == null) row = sheet.createRow(i + 1); // first row is for title
   XSSFCell cell = row.getCell(categoryData.getColIndex()); if (cell == null) cell = row.createCell(categoryData.getColIndex());
   cell.setCellValue(categoryData.getPointAt(i).toString());
   cell = row.getCell(valuesData.getColIndex()); if (cell == null) cell = row.createCell(valuesData.getColIndex());
   cell.setCellValue(valuesData.getPointAt(i).doubleValue());
  }
 }

 public static void main(String[] args) throws Exception {
  try (XWPFDocument document = new XWPFDocument()) {

   // create the data
   String[] categories = new String[]{"C1", "C2", "C3"};
   Double[] valuesA = new Double[]{300d, 20d, 10d};

   // create the chart
   XWPFChart chart = document.createChart(15*Units.EMU_PER_CENTIMETER, 10*Units.EMU_PER_CENTIMETER);

   // create data sources
   int numOfPoints = categories.length;
   String categoryDataRange = chart.formatRange(new CellRangeAddress(1, numOfPoints, 0, 0));
   String valuesDataRangeA = chart.formatRange(new CellRangeAddress(1, numOfPoints, 1, 1));
   XDDFDataSource<String> categoriesData = XDDFDataSourcesFactory.fromArray(categories, categoryDataRange, 0);
   XDDFNumericalDataSource<Double> valuesDataA = XDDFDataSourcesFactory.fromArray(valuesA, valuesDataRangeA, 1);

   // create axis
   XDDFCategoryAxis categoryAxis = chart.createCategoryAxis(AxisPosition.BOTTOM);
   categoryAxis.setTickLabelPosition(AxisTickLabelPosition.NONE);
   XDDFValueAxis valueAxis = chart.createValueAxis(AxisPosition.LEFT);
   valueAxis.setCrosses(AxisCrosses.AUTO_ZERO);
   // Set AxisCrossBetween, so the left axis crosses the category axis between the categories.
   // Else first and last category is exactly on cross points and the bars are only half visible.
   valueAxis.setCrossBetween(AxisCrossBetween.BETWEEN);

   // create chart data
   XDDFBarChartData data = (XDDFBarChartData)chart.createData(ChartTypes.BAR, categoryAxis, valueAxis);
   data.setBarDirection(BarDirection.BAR);

   // create series
   data.setVaryColors(true);
   XDDFBarChartData.Series series = (XDDFBarChartData.Series)data.addSeries(categoriesData, valuesDataA);
   // XDDFChart.setSheetTitle is buggy. It creates a Table but only half way and incomplete.
   // Excel cannot opening the workbook after creating that incomplete Table.
   // So updating the chart data in Word is not possible.
   //series.setTitle("Ser1", chart.setSheetTitle("Ser1", 1));
   series.setTitle("Ser1", setTitleInDataSheet(chart, "Ser1", 1));
   // since apache oi 4.1.1 XDDFChart does not fill the series in the sheet while plot. Apache poi 4.1.0 had done this: https://svn.apache.org/viewvc/poi/tags/REL_4_1_0/src/ooxml/java/org/apache/poi/xddf/usermodel/chart/XDDFChart.java?view=markup#l363
   // so we need doing this for each series now
   fillSheet(chart, categoriesData, valuesDataA);

   // plot chart data
   chart.plot(data);

   // Write the output to a file
   try (FileOutputStream fileOut = new FileOutputStream("CreateWordXDDFChart.docx")) {
    document.write(fileOut);
   }
  }
 }
}