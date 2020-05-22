import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.usermodel.charts.*;
import org.apache.poi.xssf.usermodel.*;

import org.apache.poi.ss.util.CellRangeAddress;

import org.apache.poi.util.Units;

public class CreateExcelLineChartAndCustomize {

 public static void main(String[] args) throws Exception {

  Workbook wb = new XSSFWorkbook();
  Sheet sheet = wb.createSheet("linechart");
  final int NUM_OF_ROWS = 100;
  final int NUM_OF_COLUMNS = 5;

  // create some data
  Row row;
  Cell cell;
  String[] headings = new String []{"x", "sin(x)", "cos(x)", "random", "random/x"};
  for (int rowIndex = 0; rowIndex < 1; rowIndex++) {
   row = sheet.createRow(rowIndex);
   for (int colIndex = 0; colIndex < NUM_OF_COLUMNS; colIndex++) {
    cell = row.createCell(colIndex);
    cell.setCellValue(headings[colIndex]);
   }
  }
  for (int rowIndex = 1; rowIndex < NUM_OF_ROWS; rowIndex++) {
   row = sheet.createRow(rowIndex);
   for (int colIndex = 0; colIndex < NUM_OF_COLUMNS; colIndex++) {
    cell = row.createCell(colIndex);
    switch (colIndex) {
     case 0:
      cell.setCellValue(rowIndex/10d);
      break;
     case 1:
      cell.setCellFormula("SIN(A" + (rowIndex+1) + ")");
      break;
     case 2:
      cell.setCellFormula("COS(A" + (rowIndex+1) + ")");
      break;
     case 3:
      cell.setCellFormula("RAND()");
      break;
     case 4:
      cell.setCellFormula("-D"+(rowIndex+1));
      break;
     default:
    }
   }
  }

  // create default chart
  Drawing<?> drawing = sheet.createDrawingPatriarch();
  ClientAnchor anchor = drawing.createAnchor(0, 0, 0, 0, 6, 1, 15, 21);

  Chart chart = drawing.createChart(anchor);
  ChartLegend legend = chart.getOrCreateLegend();
  legend.setPosition(LegendPosition.RIGHT);

  if (chart instanceof XSSFChart) ((XSSFChart)chart).setTitleText("Some lines");

  LineChartData data = chart.getChartDataFactory().createLineChartData();

  ChartAxis bottomAxis = chart.getChartAxisFactory().createCategoryAxis(AxisPosition.BOTTOM);
  ValueAxis leftAxis = chart.getChartAxisFactory().createValueAxis(AxisPosition.LEFT);
  leftAxis.setCrosses(AxisCrosses.AUTO_ZERO);

  ChartDataSource<Number> xs = DataSources.fromNumericCellRange(sheet, new CellRangeAddress(1, 99, 0, 0));
  ChartDataSource<Number> ys1 = DataSources.fromNumericCellRange(sheet, new CellRangeAddress(1, 99, 1, 1));
  ChartDataSource<Number> ys2 = DataSources.fromNumericCellRange(sheet, new CellRangeAddress(1, 99, 2, 2));
  ChartDataSource<Number> ys3 = DataSources.fromNumericCellRange(sheet, new CellRangeAddress(1, 99, 3, 3));
  ChartDataSource<Number> ys4 = DataSources.fromNumericCellRange(sheet, new CellRangeAddress(1, 99, 4, 4));

  LineChartSeries series1 = data.addSeries(xs, ys1);
  series1.setTitle("Value 1");
  LineChartSeries series2 = data.addSeries(xs, ys2);
  series2.setTitle("Value 2");
  LineChartSeries series3 = data.addSeries(xs, ys3);
  series3.setTitle("Value 3");
  LineChartSeries series4 = data.addSeries(xs, ys4);
  series4.setTitle("Value 4");

  chart.plot(data, bottomAxis, leftAxis);

  // customize the chart, this also makes it OpenOffice/Libreoffice Calc compatible
  if (chart instanceof XSSFChart) { 

   XSSFChart xssfChart = (XSSFChart)chart;

   // do not auto delete the title
   if (xssfChart.getCTChart().getAutoTitleDeleted() == null) xssfChart.getCTChart().addNewAutoTitleDeleted();
   xssfChart.getCTChart().getAutoTitleDeleted().setVal(false);

   // plot area background and border line
   if (xssfChart.getCTChartSpace().getSpPr() == null) xssfChart.getCTChartSpace().addNewSpPr();
   if (xssfChart.getCTChartSpace().getSpPr().getSolidFill() == null) 
    xssfChart.getCTChartSpace().getSpPr().addNewSolidFill();
   if (xssfChart.getCTChartSpace().getSpPr().getSolidFill().getSrgbClr() == null)
    xssfChart.getCTChartSpace().getSpPr().getSolidFill().addNewSrgbClr();
   xssfChart.getCTChartSpace().getSpPr().getSolidFill().getSrgbClr().setVal(new byte[]{(byte)255,(byte)255,(byte)255});
   if (xssfChart.getCTChartSpace().getSpPr().getLn() == null) xssfChart.getCTChartSpace().getSpPr().addNewLn();
   xssfChart.getCTChartSpace().getSpPr().getLn().setW(Units.pixelToEMU(1));
   if (xssfChart.getCTChartSpace().getSpPr().getLn().getSolidFill() == null)
    xssfChart.getCTChartSpace().getSpPr().getLn().addNewSolidFill();
   if (xssfChart.getCTChartSpace().getSpPr().getLn().getSolidFill().getSrgbClr() == null)
    xssfChart.getCTChartSpace().getSpPr().getLn().getSolidFill().addNewSrgbClr();
   xssfChart.getCTChartSpace().getSpPr().getLn().getSolidFill().getSrgbClr().setVal(new byte[]{(byte)0,(byte)0,(byte)0});

   // line style of cat axis
   if (xssfChart.getCTChart().getPlotArea().getCatAxArray(0).getSpPr() == null)
    xssfChart.getCTChart().getPlotArea().getCatAxArray(0).addNewSpPr();
   if (xssfChart.getCTChart().getPlotArea().getCatAxArray(0).getSpPr().getLn() == null)
    xssfChart.getCTChart().getPlotArea().getCatAxArray(0).getSpPr().addNewLn();
   xssfChart.getCTChart().getPlotArea().getCatAxArray(0).getSpPr().getLn().setW(Units.pixelToEMU(1));
   if (xssfChart.getCTChart().getPlotArea().getCatAxArray(0).getSpPr().getLn().getSolidFill() == null)
    xssfChart.getCTChart().getPlotArea().getCatAxArray(0).getSpPr().getLn().addNewSolidFill();
   if (xssfChart.getCTChart().getPlotArea().getCatAxArray(0).getSpPr().getLn().getSolidFill().getSrgbClr() == null)
    xssfChart.getCTChart().getPlotArea().getCatAxArray(0).getSpPr().getLn().getSolidFill().addNewSrgbClr();
   xssfChart.getCTChart().getPlotArea().getCatAxArray(0).getSpPr().getLn().getSolidFill().getSrgbClr()
    .setVal(new byte[]{(byte)0,(byte)0,(byte)0});

   //line style of val axis
   if (xssfChart.getCTChart().getPlotArea().getValAxArray(0).getSpPr() == null)
    xssfChart.getCTChart().getPlotArea().getValAxArray(0).addNewSpPr();
   if (xssfChart.getCTChart().getPlotArea().getValAxArray(0).getSpPr().getLn() == null)
    xssfChart.getCTChart().getPlotArea().getValAxArray(0).getSpPr().addNewLn();
   xssfChart.getCTChart().getPlotArea().getValAxArray(0).getSpPr().getLn().setW(Units.pixelToEMU(1));
   if (xssfChart.getCTChart().getPlotArea().getValAxArray(0).getSpPr().getLn().getSolidFill() == null)
    xssfChart.getCTChart().getPlotArea().getValAxArray(0).getSpPr().getLn().addNewSolidFill();
   if (xssfChart.getCTChart().getPlotArea().getValAxArray(0).getSpPr().getLn().getSolidFill().getSrgbClr() == null)
    xssfChart.getCTChart().getPlotArea().getValAxArray(0).getSpPr().getLn().getSolidFill().addNewSrgbClr();
   xssfChart.getCTChart().getPlotArea().getValAxArray(0).getSpPr().getLn().getSolidFill().getSrgbClr()
    .setVal(new byte[]{(byte)0,(byte)0,(byte)0});

   // line style of the series
   for (int i = 0; i < 4; i++) {
    if (xssfChart.getCTChart().getPlotArea().getLineChartArray(0).getSerArray(i).getSpPr() == null)
     xssfChart.getCTChart().getPlotArea().getLineChartArray(0).getSerArray(i).addNewSpPr();
    if (xssfChart.getCTChart().getPlotArea().getLineChartArray(0).getSerArray(i).getSpPr().getLn() == null)
     xssfChart.getCTChart().getPlotArea().getLineChartArray(0).getSerArray(i).getSpPr().addNewLn();
    xssfChart.getCTChart().getPlotArea().getLineChartArray(0).getSerArray(i)
     .getSpPr().getLn().setW(Units.pixelToEMU(3));
    if (xssfChart.getCTChart().getPlotArea().getLineChartArray(0).getSerArray(i).getSpPr().getLn().getSolidFill() == null)
     xssfChart.getCTChart().getPlotArea().getLineChartArray(0).getSerArray(i).getSpPr().getLn().addNewSolidFill();
    if (xssfChart.getCTChart().getPlotArea().getLineChartArray(0).getSerArray(i).getSpPr().getLn().getSolidFill().getSrgbClr() == null)
     xssfChart.getCTChart().getPlotArea().getLineChartArray(0).getSerArray(i).getSpPr().getLn().getSolidFill().addNewSrgbClr();
   }

   // first series red
   xssfChart.getCTChart().getPlotArea().getLineChartArray(0).getSerArray(0)
    .getSpPr().getLn().getSolidFill().getSrgbClr().setVal(new byte[]{(byte)255,(byte)0,(byte)0});

   // second series green
   xssfChart.getCTChart().getPlotArea().getLineChartArray(0).getSerArray(1)
    .getSpPr().getLn().getSolidFill().getSrgbClr().setVal(new byte[]{(byte)0,(byte)255,(byte)0});

   // third series blue
   xssfChart.getCTChart().getPlotArea().getLineChartArray(0).getSerArray(2)
    .getSpPr().getLn().getSolidFill().getSrgbClr().setVal(new byte[]{(byte)0,(byte)0,(byte)255});

   // fourth series yellow
   xssfChart.getCTChart().getPlotArea().getLineChartArray(0).getSerArray(3)
    .getSpPr().getLn().getSolidFill().getSrgbClr().setVal(new byte[]{(byte)255,(byte)255,(byte)0});


   // set line data series to not smooth the line
   for (int i = 0; i < 4; i++) {
    if (xssfChart.getCTChart().getPlotArea().getLineChartArray(0).getSerArray(i).getSmooth() == null)
     xssfChart.getCTChart().getPlotArea().getLineChartArray(0).getSerArray(i).addNewSmooth();
    xssfChart.getCTChart().getPlotArea().getLineChartArray(0).getSerArray(i).getSmooth().setVal(false);
   }

   // set or unset tick marks
   for (int i = 0; i < 4; i++) {
    if (xssfChart.getCTChart().getPlotArea().getLineChartArray(0).getSerArray(i).getMarker() == null)
     xssfChart.getCTChart().getPlotArea().getLineChartArray(0).getSerArray(i).addNewMarker();
    if (xssfChart.getCTChart().getPlotArea().getLineChartArray(0).getSerArray(i).getMarker().getSymbol() == null)
     xssfChart.getCTChart().getPlotArea().getLineChartArray(0).getSerArray(i).getMarker().addNewSymbol();
   }
   // no tick marks
   xssfChart.getCTChart().getPlotArea().getLineChartArray(0).getSerArray(0).getMarker().getSymbol().setVal(
    org.openxmlformats.schemas.drawingml.x2006.chart.STMarkerStyle.NONE);
   // diamond tick marks
   xssfChart.getCTChart().getPlotArea().getLineChartArray(0).getSerArray(1).getMarker().getSymbol().setVal(
    org.openxmlformats.schemas.drawingml.x2006.chart.STMarkerStyle.DIAMOND);
   // auto tick marks = marker set but no symbol given
   xssfChart.getCTChart().getPlotArea().getLineChartArray(0).getSerArray(2).getMarker().unsetSymbol();
   // no tick marks
   xssfChart.getCTChart().getPlotArea().getLineChartArray(0).getSerArray(3).getMarker().getSymbol().setVal(
    org.openxmlformats.schemas.drawingml.x2006.chart.STMarkerStyle.NONE);

  }


  wb.write(new FileOutputStream("CreateExcelLineChartAndCustomize.xlsx"));
  wb.close();

 }

}