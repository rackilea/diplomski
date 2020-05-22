import java.io.*;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.usermodel.charts.*;
import org.apache.poi.ss.util.CellRangeAddress;

import org.apache.poi.xssf.usermodel.*;
import org.apache.poi.xssf.model.ExternalLinksTable;

import org.apache.poi.openxml4j.opc.*;
import org.apache.poi.POIXMLDocumentPart;

import org.openxmlformats.schemas.spreadsheetml.x2006.main.ExternalLinkDocument;

import static org.apache.poi.POIXMLTypeLoader.DEFAULT_XML_OPTIONS;

public class CreateExcelLineChartDataAnotherWorkbook {

 private static String datawbname = "DataWB.xlsx";
 private static String chartwbname = "ChartWB.xlsx";

 public CreateExcelLineChartDataAnotherWorkbook() throws Exception {
  Workbook datawb = createDataSpreadsheet("ChartDataSheet");
  saveWorkbook(datawb, "/home/axel/Dokumente/"+datawbname);

  Workbook chartwb = createLineChart("ChartSheet", (XSSFWorkbook)datawb);
  saveWorkbook(chartwb, "/home/axel/Dokumente/"+chartwbname);
 }

 //your method only partially changed to have sample data
 public XSSFWorkbook createDataSpreadsheet(String name) {
  Workbook workbook = new XSSFWorkbook();
  Sheet sheet = workbook.createSheet(name);

  int rowNumber = 0;
  for(int i = 0; i < 20; i++) {
   Row row = sheet.createRow(rowNumber++);

   int columnNumber = 0;
   row.createCell(columnNumber++).setCellValue(Math.PI*i/10*2);
   row.createCell(columnNumber++).setCellValue(Math.sin(Math.PI*i/10*2));
  }

  return (XSSFWorkbook)workbook;
 }

 //method for saving the workbooks
 public void saveWorkbook(Workbook wb, String path) throws Exception {
  wb.write(new FileOutputStream(path));
  wb.close();
 }

 //your method changes are commented
 public XSSFWorkbook createLineChart(String name, XSSFWorkbook data) throws Exception {
  Workbook workbook = new XSSFWorkbook();

  //create the external link to datawbname
  int extwbid = 1;
  createExternalLinkToWorksheet((XSSFWorkbook)workbook, datawbname, "ChartDataSheet", "rId"+extwbid);

  Sheet sheet = workbook.createSheet(name);

  Drawing drawing = sheet.createDrawingPatriarch();
  ClientAnchor anchor = drawing.createAnchor(0, 0, 0, 0, 0, 0, 15, 15);
  Chart lineChart = drawing.createChart(anchor);

  ChartLegend legend = lineChart.getOrCreateLegend();
  legend.setPosition(LegendPosition.BOTTOM); 

  LineChartData chartData = lineChart.getChartDataFactory().createLineChartData();     
  ChartAxis bottomAxis = lineChart.getChartAxisFactory().createCategoryAxis(AxisPosition.BOTTOM);
  ValueAxis leftAxis = lineChart.getChartAxisFactory().createValueAxis(AxisPosition.LEFT);
  leftAxis.setCrosses(AxisCrosses.AUTO_ZERO);

  Sheet dataSheet = data.getSheetAt(0);
  ChartDataSource<Number> xData = DataSources.fromNumericCellRange(dataSheet, new CellRangeAddress(0, dataSheet.getLastRowNum(), 0, 0));
  ChartDataSource<Number> yData = DataSources.fromNumericCellRange(dataSheet, new CellRangeAddress(0, dataSheet.getLastRowNum(), 1, 1));

  LineChartSeries chartSeries = chartData.addSeries(xData, yData);
  chartSeries.setTitle("A title");

  lineChart.plot(chartData, new ChartAxis[] { bottomAxis, leftAxis });

  //since dataSheet is an external sheet, the formula in the org.openxmlformats.schemas.drawingml.x2006.chart.CTNumRef
  //must be prefixed with [1], where 1 is the Id of the linked workbook 
  String catref = ((XSSFChart)lineChart).getCTChart().getPlotArea().getLineChartArray(0).getSerArray(0).getCat().getNumRef().getF();
  ((XSSFChart)lineChart).getCTChart().getPlotArea().getLineChartArray(0).getSerArray(0).getCat().getNumRef().setF("[" + extwbid + "]" + catref);
  String valref = ((XSSFChart)lineChart).getCTChart().getPlotArea().getLineChartArray(0).getSerArray(0).getVal().getNumRef().getF();
  ((XSSFChart)lineChart).getCTChart().getPlotArea().getLineChartArray(0).getSerArray(0).getVal().getNumRef().setF("[" + extwbid + "]" + valref);

  return (XSSFWorkbook)workbook;
 }

 //method for creating a external link to a sheet in another workbook
 public void createExternalLinkToWorksheet(XSSFWorkbook workbook, String wbname, String sheetname, String rIdExtWb) throws Exception {
  OPCPackage opcpackage = workbook.getPackage();

  //creating /xl/externalLinks/externalLink1.xml having link to externalBook with external sheetName
  PackagePartName partname = PackagingURIHelper.createPartName("/xl/externalLinks/externalLink1.xml");
  PackagePart part = opcpackage.createPart(partname, "application/vnd.openxmlformats-officedocument.spreadsheetml.externalLink+xml");
  POIXMLDocumentPart externallinkstable = new POIXMLDocumentPart(part) {
   @Override
   protected void commit() throws IOException {
    PackagePart part = getPackagePart();
    OutputStream out = part.getOutputStream();
    try {
     ExternalLinkDocument doc = ExternalLinkDocument.Factory.parse(
      "<externalLink xmlns=\"http://schemas.openxmlformats.org/spreadsheetml/2006/main\">"
     +"<externalBook xmlns:r=\"http://schemas.openxmlformats.org/officeDocument/2006/relationships\" r:id=\""+ rIdExtWb + "\">"
     +"<sheetNames><sheetName val=\"" + sheetname + "\"/></sheetNames>"
     +"</externalBook>"
     +"</externalLink>"
     );
     doc.save(out, DEFAULT_XML_OPTIONS);
     out.close();
    } catch (Exception ex) {
     ex.printStackTrace();
    }; 
   }
  };
  //creating the relation to the external workbook in /xl/externalLinks/_rels/externalLink1.xml.rels
  PackageRelationship packrelship = part.addRelationship(new java.net.URI(wbname), TargetMode.EXTERNAL, "http://schemas.openxmlformats.org/officeDocument/2006/relationships/externalLinkPath", rIdExtWb);

  //creating the relation to /xl/externalLinks/externalLink1.xml in /xl/_rels/workbook.xml.rels
  String rIdExtLink = "rId" + (workbook.getRelationParts().size()+1);
  workbook.addRelation(rIdExtLink, XSSFRelation.EXTERNAL_LINKS, externallinkstable);

  //creating the <externalReferences><externalReference .../> in /xl/workbook.xml
  workbook.getCTWorkbook().addNewExternalReferences().addNewExternalReference().setId(rIdExtLink);

 }

 public static void main(String[] args) throws Exception {
  CreateExcelLineChartDataAnotherWorkbook mainObject = new CreateExcelLineChartDataAnotherWorkbook();
 }

}