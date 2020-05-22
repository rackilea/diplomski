import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.usermodel.charts.*;
import org.apache.poi.ss.util.CellRangeAddress;

import org.apache.poi.xssf.usermodel.*;

public class LineChartProblem {

 public static void main(String[] args) throws IOException {
  try (XSSFWorkbook wb = new XSSFWorkbook()) {

   Sheet sheet = wb.createSheet("linechart");
   Drawing drawing = sheet.createDrawingPatriarch();
   ClientAnchor anchor = drawing.createAnchor(0, 0, 0, 0, 0, 5, 10, 15);

   Chart chart = drawing.createChart(anchor);
   ((XSSFChart)chart).setTitleText("This is my title");

   //set "the title overlays the plot area" to false explicitly
   ((XSSFChart)chart).getCTChart().getTitle().addNewOverlay().setVal(false);

   //set font style for title - low level
   //add run properties to title's first paragraph and first text run. Set bold.
   ((XSSFChart)chart).getCTChart().getTitle().getTx().getRich().getPArray(0).getRArray(0).addNewRPr().setB(true);
   //set italic
   ((XSSFChart)chart).getCTChart().getTitle().getTx().getRich().getPArray(0).getRArray(0).getRPr().setI(true);
   //set font size 20pt
   ((XSSFChart)chart).getCTChart().getTitle().getTx().getRich().getPArray(0).getRArray(0).getRPr().setSz(2000);
   //add type face for latin and complex script characters
   ((XSSFChart)chart).getCTChart().getTitle().getTx().getRich().getPArray(0).getRArray(0).getRPr().addNewLatin().setTypeface("Times New Roman");
   ((XSSFChart)chart).getCTChart().getTitle().getTx().getRich().getPArray(0).getRArray(0).getRPr().addNewCs().setTypeface("Times New Roman");

   // Use a category axis for the bottom axis.
   ChartAxis bottomAxis = chart.getChartAxisFactory().createCategoryAxis(AxisPosition.BOTTOM);
   ValueAxis leftAxis = chart.getChartAxisFactory().createValueAxis(AxisPosition.LEFT);

   ChartDataSource<Integer> test = DataSources.fromArray(new Integer[]{2011,2012,2013,2014,2015,2016,2017});
   ChartDataSource<Integer> test2 = DataSources.fromArray(new Integer[]{4805, 7351, 5333, 7183, 6230, 4050, 6963});

   LineChartData data = chart.getChartDataFactory().createLineChartData();
   data.addSeries(test, test2);
   chart.plot(data, bottomAxis, leftAxis);

   // Write the output to a file
   try (FileOutputStream fileOut = new FileOutputStream("ooxml-line-chart.xlsx")) {
    wb.write(fileOut);
   }
  }
 }
}