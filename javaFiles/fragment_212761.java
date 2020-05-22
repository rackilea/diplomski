import java.io.*;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.usermodel.charts.*;
import org.apache.poi.ss.util.CellRangeAddress;

import org.apache.poi.xssf.usermodel.*;
import org.apache.poi.xssf.model.ExternalLinksTable;

import org.apache.poi.openxml4j.opc.*;
import org.apache.poi.POIXMLDocumentPart;

import org.openxmlformats.schemas.spreadsheetml.x2006.main.ExternalLinkDocument;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTExternalReferences;

import static org.apache.poi.POIXMLTypeLoader.DEFAULT_XML_OPTIONS;

import java.lang.reflect.Field;

import java.util.List;
import java.util.ArrayList;

public class CreateExcelLineChartExternalLinksTable {

 private static String datawbname = "DataWB.xlsx";
 private static String chartwbname = "ChartWB.xlsx";

 public CreateExcelLineChartExternalLinksTable() throws Exception {
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
  Workbook workbook = new MyXSSFWorkbook();

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

  //create the ExternalLinksTable for the linked workbook and sheet
  int extLinksId = ((MyXSSFWorkbook)workbook).createExternalLinksTableWbSheet(datawbname, "ChartDataSheet");
System.out.println(((XSSFWorkbook)workbook).getExternalLinksTable());

  //since dataSheet is an external sheet, the formula in the org.openxmlformats.schemas.drawingml.x2006.chart.CTNumRef
  //must be prefixed with [1], where 1 is the Id of the linked workbook 
  String catref = ((XSSFChart)lineChart).getCTChart().getPlotArea().getLineChartArray(0).getSerArray(0).getCat().getNumRef().getF();
  ((XSSFChart)lineChart).getCTChart().getPlotArea().getLineChartArray(0).getSerArray(0).getCat().getNumRef().setF("["+extLinksId+"]" + catref);
  String valref = ((XSSFChart)lineChart).getCTChart().getPlotArea().getLineChartArray(0).getSerArray(0).getVal().getNumRef().getF();
  ((XSSFChart)lineChart).getCTChart().getPlotArea().getLineChartArray(0).getSerArray(0).getVal().getNumRef().setF("["+extLinksId+"]" + valref);

  return (XSSFWorkbook)workbook;
 }

 public static void main(String[] args) throws Exception {
  CreateExcelLineChartExternalLinksTable mainObject = new CreateExcelLineChartExternalLinksTable();
 }

 //class which extends XSSFWorkbook and provides a method for creating ExternalLinksTable for linked workbook and sheet
 private class MyXSSFWorkbook extends XSSFWorkbook {

  //method for creating ExternalLinksTable for linked workbook and sheet
  //returns the Id of this ExternalLinksTable
  int createExternalLinksTableWbSheet(String wbname, String sheetname) throws Exception {

   List<ExternalLinksTable> elternallinkstablelist = getExternalLinksTable();
   int extLinksId = 1;
   if (elternallinkstablelist != null) extLinksId = elternallinkstablelist.size()+1;

   OPCPackage opcpackage = getPackage();

   //creating /xl/externalLinks/externalLink1.xml having link to externalBook with external sheetName
   PackagePartName partname = PackagingURIHelper.createPartName("/xl/externalLinks/externalLink"+extLinksId+".xml");
   PackagePart part = opcpackage.createPart(partname, "application/vnd.openxmlformats-officedocument.spreadsheetml.externalLink+xml");

   OutputStream out = part.getOutputStream();
   ExternalLinkDocument doc = ExternalLinkDocument.Factory.parse(
     "<externalLink xmlns=\"http://schemas.openxmlformats.org/spreadsheetml/2006/main\">"
    +"<externalBook xmlns:r=\"http://schemas.openxmlformats.org/officeDocument/2006/relationships\" r:id=\"rId1\">"
    +"<sheetNames><sheetName val=\"" + sheetname + "\"/></sheetNames>"
    +"</externalBook>"
    +"</externalLink>"
   );
   doc.save(out, DEFAULT_XML_OPTIONS);
   out.close();

   //creating the relation to the external workbook in /xl/externalLinks/_rels/externalLink1.xml.rels
   PackageRelationship packrelship = part.addRelationship(new java.net.URI(wbname), TargetMode.EXTERNAL, "http://schemas.openxmlformats.org/officeDocument/2006/relationships/externalLinkPath", "rId1");

   ExternalLinksTable externallinkstable = new ExternalLinksTable(part);

   //creating the relation to /xl/externalLinks/externalLink1.xml in /xl/_rels/workbook.xml.rels
   String rIdExtLink = "rId" + (getRelationParts().size()+1);
   addRelation(rIdExtLink, XSSFRelation.EXTERNAL_LINKS, externallinkstable);

   //creating the <externalReferences><externalReference .../> in /xl/workbook.xml
   CTExternalReferences externalreferences = getCTWorkbook().getExternalReferences();
   if (externalreferences == null) externalreferences = getCTWorkbook().addNewExternalReferences();
   externalreferences.addNewExternalReference().setId(rIdExtLink);

   Field externalLinksField = XSSFWorkbook.class.getDeclaredField("externalLinks"); 
   externalLinksField.setAccessible(true);
   @SuppressWarnings("unchecked") //we know the problem and expect runtime error if it possibly occurs
   List<ExternalLinksTable> externalLinks = (ArrayList<ExternalLinksTable>)externalLinksField.get(this);
   if (externalLinks == null) {
    externalLinks = new ArrayList<ExternalLinksTable>();
    externalLinks.add(externallinkstable);
    externalLinksField.set(this, externalLinks);
   } else {
    externalLinks.add(externallinkstable);
   }

   return extLinksId;
  }
 }
}