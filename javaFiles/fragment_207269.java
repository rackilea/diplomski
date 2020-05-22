import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.util.*;
import org.apache.poi.xssf.usermodel.XSSFChart;
import org.apache.poi.ss.SpreadsheetVersion;

import org.openxmlformats.schemas.drawingml.x2006.chart.*;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import java.util.ArrayList;

class ExcelCharWithTargetLine {

 private static CTChart createBarChart(XSSFChart chart, String dataSheet, ArrayList<Integer> cols, int lastRow, double target) {

  CTChart ctChart = chart.getCTChart();
  CTPlotArea ctPlotArea = ctChart.getPlotArea();
  CTBarChart ctBarChart = ctPlotArea.addNewBarChart();
  CTBoolean ctBoolean = ctBarChart.addNewVaryColors();
  ctBoolean.setVal(true);
  ctBarChart.addNewBarDir().setVal(cols.size() > 1 ? STBarDir.COL : STBarDir.BAR);

  int idx = 0;

  for (Integer c : cols) {
   CTBarSer ctBarSer = ctBarChart.addNewSer();
   CTSerTx ctSerTx = ctBarSer.addNewTx();
   CTStrRef ctStrRef = ctSerTx.addNewStrRef();
   ctStrRef.setF(new CellReference(dataSheet, 0, c, true, true).formatAsString());

   ctBarSer.addNewIdx().setVal(idx++);
   CTAxDataSource cttAxDataSource = ctBarSer.addNewCat();
   ctStrRef = cttAxDataSource.addNewStrRef();

   ctStrRef.setF(new AreaReference(
                  new CellReference(dataSheet, 1, 0, true, true), 
                  new CellReference(dataSheet, lastRow, 0, true, true), 
                  SpreadsheetVersion.EXCEL2007).formatAsString()
                 );

   CTNumDataSource ctNumDataSource = ctBarSer.addNewVal();
   CTNumRef ctNumRef = ctNumDataSource.addNewNumRef();

   ctNumRef.setF(new AreaReference(
                  new CellReference(dataSheet, 1, c, true, true), 
                  new CellReference(dataSheet, lastRow, c, true, true), 
                  SpreadsheetVersion.EXCEL2007).formatAsString()
                 );

   // at least the border lines in Libreoffice Calc ;-)
   //ctBarSer.addNewSpPr().addNewLn().addNewSolidFill().addNewSrgbClr().setVal(new byte[] { 0, 0, 0 });

  }

  // telling the BarChart that it has axes and giving them Ids
  ctBarChart.addNewAxId().setVal(123456);
  ctBarChart.addNewAxId().setVal(123457);

  // cat axis
  CTCatAx ctCatAx = ctPlotArea.addNewCatAx();
  ctCatAx.addNewAxId().setVal(123456); // id of the cat axis
  CTScaling ctScaling = ctCatAx.addNewScaling();
  ctScaling.addNewOrientation().setVal(STOrientation.MIN_MAX);
  ctCatAx.addNewDelete().setVal(false);
  ctCatAx.addNewAxPos().setVal(STAxPos.B);
  ctCatAx.addNewCrossAx().setVal(123457); // id of the val axis
  ctCatAx.addNewTickLblPos().setVal(STTickLblPos.NEXT_TO);

  // val axis
  CTValAx ctValAx = ctPlotArea.addNewValAx();
  ctValAx.addNewAxId().setVal(123457); // id of the val axis
  ctScaling = ctValAx.addNewScaling();
  ctScaling.addNewOrientation().setVal(STOrientation.MIN_MAX);
  ctValAx.addNewDelete().setVal(false);
  ctValAx.addNewAxPos().setVal(STAxPos.L);
  ctValAx.addNewCrossAx().setVal(123456); // id of the cat axis
  ctValAx.addNewTickLblPos().setVal(STTickLblPos.NEXT_TO);


  // target line
  // line of a scatter chart from 0 (min) to 1 (max) having value of double target
  CTScatterChart ctScatterChart = ctPlotArea.addNewScatterChart();
  ctBoolean = ctScatterChart.addNewVaryColors();
  ctBoolean.setVal(true);

  CTScatterSer ctScatterSer = ctScatterChart.addNewSer();
  ctScatterSer.addNewIdx().setVal(idx++);
  ctScatterSer.addNewMarker().addNewSymbol().setVal(STMarkerStyle.NONE);

  CTNumData ctNumData = ctScatterSer.addNewXVal().addNewNumLit();
  ctNumData.addNewPtCount().setVal(2);
  CTNumVal ctNumVal = ctNumData.addNewPt();
  ctNumVal.setIdx(0);

  if (cols.size() > 1) {
   ctNumVal.setV("0"); // if STBarDir.COL then X axis is from 0 to 1
  } else {
   ctNumVal.setV("" + target); // if STBarDir.BAR then X axis is value axis
  }

  ctNumVal = ctNumData.addNewPt();
  ctNumVal.setIdx(1);

  if (cols.size() > 1) {
   ctNumVal.setV("1");
  } else {
   ctNumVal.setV("" + target);
  }

  ctNumData = ctScatterSer.addNewYVal().addNewNumLit();
  ctNumData.addNewPtCount().setVal(2);
  ctNumVal = ctNumData.addNewPt();
  ctNumVal.setIdx(0);

  if (cols.size() > 1) {
   ctNumVal.setV("" + target); // if STBarDir.COL then Y axis is value axis
  } else {
   ctNumVal.setV("0"); // if STBarDir.BAR then Y axis is from 0 to 1
  }

  ctNumVal = ctNumData.addNewPt();
  ctNumVal.setIdx(1);

  if (cols.size() > 1) {
   ctNumVal.setV("" + target);
  } else {
   ctNumVal.setV("1");
  }

  ctScatterChart.addNewAxId().setVal(123458);
  ctScatterChart.addNewAxId().setVal(123459);

  ctValAx = ctPlotArea.addNewValAx();
  ctValAx.addNewAxId().setVal(123458); // id of the X axis
  ctScaling = ctValAx.addNewScaling();
  ctScaling.addNewOrientation().setVal(STOrientation.MIN_MAX);
  if (cols.size() > 1) {
   ctScaling.addNewMax().setVal(1.0);
  }
  ctValAx.addNewDelete().setVal(true);
  ctValAx.addNewAxPos().setVal(STAxPos.T);
  ctValAx.addNewCrossAx().setVal(123459); // id of the Y axis
  ctValAx.addNewTickLblPos().setVal(STTickLblPos.NONE);

  ctValAx = ctPlotArea.addNewValAx();
  ctValAx.addNewAxId().setVal(123459); // id of the Y axis
  ctScaling = ctValAx.addNewScaling();
  ctScaling.addNewOrientation().setVal(STOrientation.MIN_MAX);
  if (cols.size() == 1) {
   ctScaling.addNewMax().setVal(1.0);
  }
  ctValAx.addNewDelete().setVal(true);
  ctValAx.addNewAxPos().setVal(STAxPos.R);
  ctValAx.addNewCrossAx().setVal(123458); // id of the X axis
  ctValAx.addNewTickLblPos().setVal(STTickLblPos.NONE);


  // legend
  if (cols.size() > 1) {
   CTLegend ctLegend = ctChart.addNewLegend();
   ctLegend.addNewLegendPos().setVal(STLegendPos.L);

   // delete additional target line series legent entry
   CTLegendEntry ctLegendEntry = ctLegend.addNewLegendEntry();
   ctLegendEntry.addNewIdx().setVal(0);
   ctLegendEntry.addNewDelete().setVal(true);

   ctLegend.addNewOverlay().setVal(false);
  }

  return ctChart;

 }

 public static void main(String[] args) throws Exception {

  Workbook workbook = WorkbookFactory.create(new FileInputStream("ExcelChart.xlsx"));

  Sheet sheet = workbook.getSheetAt(0);

  ArrayList<Integer> cols = new ArrayList<Integer>();
  //cols.add(1);
  cols.add(2);
  //cols.add(3);

  Drawing drawing = sheet.createDrawingPatriarch();
  ClientAnchor anchor = null;
  if (cols.size() > 1) {
   anchor = drawing.createAnchor(0, 0, 0, 0, 0, 8, 10, 23);
  } else {
   anchor = drawing.createAnchor(0, 0, 0, 0, 0, 8, 5, 23);
  }
  Chart chart = drawing.createChart(anchor);
  CTChart ctChart = ctChart = createBarChart((XSSFChart) chart, sheet.getSheetName(), cols, 6, 42.0);

  workbook.write(new FileOutputStream("ExcelChartNew.xlsx"));
  workbook.close();

 }
}