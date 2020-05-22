import java.io.FileOutputStream;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xddf.usermodel.PresetColor;
import org.apache.poi.xddf.usermodel.XDDFColor;
import org.apache.poi.xddf.usermodel.XDDFShapeProperties;
import org.apache.poi.xddf.usermodel.XDDFSolidFillProperties;
import org.apache.poi.xddf.usermodel.chart.AxisCrosses;
import org.apache.poi.xddf.usermodel.chart.AxisCrossBetween;
import org.apache.poi.xddf.usermodel.chart.AxisPosition;
import org.apache.poi.xddf.usermodel.chart.ChartTypes;
import org.apache.poi.xddf.usermodel.chart.LegendPosition;
import org.apache.poi.xddf.usermodel.chart.XDDFCategoryAxis;
import org.apache.poi.xddf.usermodel.chart.XDDFChartData;
import org.apache.poi.xddf.usermodel.chart.XDDFChartLegend;
import org.apache.poi.xddf.usermodel.chart.XDDFDataSource;
import org.apache.poi.xddf.usermodel.chart.XDDFDataSourcesFactory;
import org.apache.poi.xddf.usermodel.chart.XDDFNumericalDataSource;
import org.apache.poi.xddf.usermodel.chart.XDDFValueAxis;
import org.apache.poi.xssf.usermodel.XSSFChart;
import org.apache.poi.xssf.usermodel.XSSFClientAnchor;
import org.apache.poi.xssf.usermodel.XSSFDrawing;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelBarChartFromExistingData {

  public static void main(String[] args) throws IOException {
    try (XSSFWorkbook wb = (XSSFWorkbook)WorkbookFactory.create(new FileInputStream("Workbook.xlsx"))) {
      XSSFSheet sheet = wb.getSheet("Sheet1");

      XSSFDrawing drawing = sheet.createDrawingPatriarch();
      XSSFClientAnchor anchor = drawing.createAnchor(0, 0, 0, 0, 0, 5, 10, 15);

      XSSFChart chart = drawing.createChart(anchor);
      XDDFChartLegend legend = chart.getOrAddLegend();
      legend.setPosition(LegendPosition.TOP_RIGHT);

      // Use a category axis for the bottom axis.
      XDDFCategoryAxis bottomAxis = chart.createCategoryAxis(AxisPosition.BOTTOM);
      XDDFValueAxis leftAxis = chart.createValueAxis(AxisPosition.LEFT);
      leftAxis.setCrosses(AxisCrosses.AUTO_ZERO);
      leftAxis.setCrossBetween(AxisCrossBetween.BETWEEN);

      XDDFDataSource<String> xs = XDDFDataSourcesFactory.fromStringCellRange(sheet,
          new CellRangeAddress(1, 3, 1, 1));
      XDDFNumericalDataSource<Double> ys = XDDFDataSourcesFactory.fromNumericCellRange(sheet,
          new CellRangeAddress(1, 3, 5, 5));

      XDDFChartData data = chart.createData(ChartTypes.BAR, bottomAxis, leftAxis);
      data.addSeries(xs, ys);
      chart.plot(data);

      //Since XDDF stuff is buggy until now, we need to repair something.

      //repairing set the kind of bar char, either bar chart or column chart:
      if (chart.getCTChart().getPlotArea().getBarChartArray(0).getBarDir() == null) 
       chart.getCTChart().getPlotArea().getBarChartArray(0).addNewBarDir();
      chart.getCTChart().getPlotArea().getBarChartArray(0).getBarDir().setVal(
       org.openxmlformats.schemas.drawingml.x2006.chart.STBarDir.COL);
       //org.openxmlformats.schemas.drawingml.x2006.chart.STBarDir.BAR);

      //repairing telling the axis Ids in bar chart:
      if (chart.getCTChart().getPlotArea().getBarChartArray(0).getAxIdList().size() == 0) {
       chart.getCTChart().getPlotArea().getBarChartArray(0).addNewAxId().setVal(bottomAxis.getId());
       chart.getCTChart().getPlotArea().getBarChartArray(0).addNewAxId().setVal(leftAxis.getId());
      }

      //repairing no Tx when there is no title
      if (chart.getCTChart().getPlotArea().getBarChartArray(0).getSerArray(0).getTx() != null)
       chart.getCTChart().getPlotArea().getBarChartArray(0).getSerArray(0).unsetTx();

      XDDFSolidFillProperties fill = new XDDFSolidFillProperties(XDDFColor.from(PresetColor.BLUE));
      XDDFChartData.Series firstSeries = data.getSeries().get(0);
      XDDFShapeProperties properties = firstSeries.getShapeProperties();
      if (properties == null) {
        properties = new XDDFShapeProperties();
      }
      properties.setFillProperties(fill);
      firstSeries.setShapeProperties(properties);

      // Write the output to a file
      try (FileOutputStream fileOut = new FileOutputStream("WorkbookNew.xlsx")) {
        wb.write(fileOut);
      }
    }
  }
}