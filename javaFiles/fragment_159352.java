import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.util.*;

import org.apache.poi.ss.SpreadsheetVersion;
import org.apache.poi.xssf.usermodel.XSSFDrawing;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFChart;

import org.openxmlformats.schemas.drawingml.x2006.chart.CTChart;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTPlotArea;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTBarChart;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTBoolean;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTBarSer;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTAxDataSource;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTNumDataSource;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTNumRef;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTStrRef;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTSerTx;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTCatAx;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTValAx;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTScaling;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTLegend;
import org.openxmlformats.schemas.drawingml.x2006.chart.STAxPos;
import org.openxmlformats.schemas.drawingml.x2006.chart.STBarDir;
import org.openxmlformats.schemas.drawingml.x2006.chart.STOrientation;
import org.openxmlformats.schemas.drawingml.x2006.chart.STLegendPos;
import org.openxmlformats.schemas.drawingml.x2006.chart.STTickLblPos;

public class BarChart {

    private static CTChart createDefaultBarChart(XSSFChart chart, CellReference firstDataCell, CellReference lastDataCell, boolean seriesInCols) {

        CTChart ctChart = chart.getCTChart();
        CTPlotArea ctPlotArea = ctChart.getPlotArea();
        CTBarChart ctBarChart = ctPlotArea.addNewBarChart();
        CTBoolean ctBoolean = ctBarChart.addNewVaryColors();
        ctBoolean.setVal(true);
        ctBarChart.addNewBarDir().setVal(STBarDir.COL);

        int firstDataRow = firstDataCell.getRow();
        int lastDataRow = lastDataCell.getRow();
        int firstDataCol = firstDataCell.getCol();
        int lastDataCol = lastDataCell.getCol();
        String dataSheet = firstDataCell.getSheetName();

        int idx = 0;

        if (seriesInCols) { //the series are in the columns of the data cells

            for (int c = firstDataCol + 1; c < lastDataCol + 1; c++) {
                CTBarSer ctBarSer = ctBarChart.addNewSer();
                CTSerTx ctSerTx = ctBarSer.addNewTx();
                CTStrRef ctStrRef = ctSerTx.addNewStrRef();
                ctStrRef.setF(new CellReference(dataSheet, firstDataRow, c, true, true).formatAsString());

                ctBarSer.addNewIdx().setVal(idx++);
                CTAxDataSource cttAxDataSource = ctBarSer.addNewCat();
                ctStrRef = cttAxDataSource.addNewStrRef();

                ctStrRef.setF(new AreaReference(
                        new CellReference(dataSheet, firstDataRow + 1, firstDataCol, true, true),
                        new CellReference(dataSheet, lastDataRow, firstDataCol, true, true),
                        SpreadsheetVersion.EXCEL2007).formatAsString());

                CTNumDataSource ctNumDataSource = ctBarSer.addNewVal();
                CTNumRef ctNumRef = ctNumDataSource.addNewNumRef();

                ctNumRef.setF(new AreaReference(
                        new CellReference(dataSheet, firstDataRow + 1, c, true, true),
                        new CellReference(dataSheet, lastDataRow, c, true, true),
                        SpreadsheetVersion.EXCEL2007).formatAsString());

                //at least the border lines in Libreoffice Calc ;-)
                ctBarSer.addNewSpPr().addNewLn().addNewSolidFill().addNewSrgbClr().setVal(new byte[] {0,0,0});

            }
        } else { //the series are in the rows of the data cells

            for (int r = firstDataRow + 1; r < lastDataRow + 1; r++) {
                CTBarSer ctBarSer = ctBarChart.addNewSer();
                CTSerTx ctSerTx = ctBarSer.addNewTx();
                CTStrRef ctStrRef = ctSerTx.addNewStrRef();
                ctStrRef.setF(new CellReference(dataSheet, r, firstDataCol, true, true).formatAsString());

                ctBarSer.addNewIdx().setVal(idx++);
                CTAxDataSource cttAxDataSource = ctBarSer.addNewCat();
                ctStrRef = cttAxDataSource.addNewStrRef();

                ctStrRef.setF(new AreaReference(
                        new CellReference(dataSheet, firstDataRow, firstDataCol + 1, true, true),
                        new CellReference(dataSheet, firstDataRow, lastDataCol, true, true),
                        SpreadsheetVersion.EXCEL2007).formatAsString());

                CTNumDataSource ctNumDataSource = ctBarSer.addNewVal();
                CTNumRef ctNumRef = ctNumDataSource.addNewNumRef();

                ctNumRef.setF(new AreaReference(
                        new CellReference(dataSheet, r, firstDataCol + 1, true, true),
                        new CellReference(dataSheet, r, lastDataCol, true, true),
                        SpreadsheetVersion.EXCEL2007).formatAsString());

                //at least the border lines in Libreoffice Calc ;-)
                ctBarSer.addNewSpPr().addNewLn().addNewSolidFill().addNewSrgbClr().setVal(new byte[] {0,0,0});

            }
        }

        //telling the BarChart that it has axes and giving them Ids
        ctBarChart.addNewAxId().setVal(123456);
        ctBarChart.addNewAxId().setVal(123457);

        //cat axis
        CTCatAx ctCatAx = ctPlotArea.addNewCatAx();
        ctCatAx.addNewAxId().setVal(123456); //id of the cat axis
        CTScaling ctScaling = ctCatAx.addNewScaling();
        ctScaling.addNewOrientation().setVal(STOrientation.MIN_MAX);
        ctCatAx.addNewDelete().setVal(false);
        ctCatAx.addNewAxPos().setVal(STAxPos.B);
        ctCatAx.addNewCrossAx().setVal(123457); //id of the val axis
        ctCatAx.addNewTickLblPos().setVal(STTickLblPos.NEXT_TO);

        //val axis
        CTValAx ctValAx = ctPlotArea.addNewValAx();
        ctValAx.addNewAxId().setVal(123457); //id of the val axis
        ctScaling = ctValAx.addNewScaling();
        ctScaling.addNewOrientation().setVal(STOrientation.MIN_MAX);
        ctValAx.addNewDelete().setVal(false);
        ctValAx.addNewAxPos().setVal(STAxPos.L);
        ctValAx.addNewCrossAx().setVal(123456); //id of the cat axis
        ctValAx.addNewTickLblPos().setVal(STTickLblPos.NEXT_TO);

        //legend
        CTLegend ctLegend = ctChart.addNewLegend();
        ctLegend.addNewLegendPos().setVal(STLegendPos.B);
        ctLegend.addNewOverlay().setVal(false);

        return ctChart;

    }

    public static void main(String[] args) throws Exception {
        XSSFWorkbook wb = new XSSFWorkbook();
        XSSFSheet sheet = wb.createSheet("Sheet1");

        DataFormat format = wb.createDataFormat();

        CellStyle oneDecimal = wb.createCellStyle();
        oneDecimal.setDataFormat(format.getFormat("0.0"));

        //put some data in the sheet
        Row row;
        Cell cell;

        row = sheet.createRow(0);
        row.createCell(0);
        row.createCell(1).setCellValue("Male");
        row.createCell(2).setCellValue("Female");

        for (int r = 1; r < 7; r++) {
            row = sheet.createRow(r);
            cell = row.createCell(0);
            cell.setCellValue(1975 + r * 5);
            cell = row.createCell(1);
            cell.setCellValue(java.util.concurrent.ThreadLocalRandom.current().nextDouble(40.0, 70.0));
            cell.setCellStyle(oneDecimal);
            cell = row.createCell(2);
            cell.setCellValue(java.util.concurrent.ThreadLocalRandom.current().nextDouble(40.0, 70.0));
            cell.setCellStyle(oneDecimal);
        }

        //create empty chart in the sheet
        XSSFDrawing drawing = sheet.createDrawingPatriarch();
        ClientAnchor anchor = drawing.createAnchor(0, 0, 0, 0, 0, 7, 8, 20);

        XSSFChart chart = drawing.createChart(anchor);

        //create the references to the chart data
        CellReference firstDataCell = new CellReference(sheet.getSheetName(), 0, 0, true, true);
        CellReference lastDataCell = new CellReference(sheet.getSheetName(), 6, 2, true, true);

        //create a default bar chart from the data
        CTChart ctBarChart = createDefaultBarChart(chart, firstDataCell, lastDataCell, true);

        //now we can customizing the chart

        //legend position:
        ctBarChart.getLegend().unsetLegendPos();
        ctBarChart.getLegend().addNewLegendPos().setVal(STLegendPos.R);

        //data labels:
        CTBoolean ctboolean = CTBoolean.Factory.newInstance();
        ctboolean.setVal(true);
        ctBarChart.getPlotArea().getBarChartArray(0).addNewDLbls().setShowVal(ctboolean);
        ctboolean.setVal(false);
        ctBarChart.getPlotArea().getBarChartArray(0).getDLbls().setShowSerName(ctboolean);
        ctBarChart.getPlotArea().getBarChartArray(0).getDLbls().setShowPercent(ctboolean);
        ctBarChart.getPlotArea().getBarChartArray(0).getDLbls().setShowLegendKey(ctboolean);
        ctBarChart.getPlotArea().getBarChartArray(0).getDLbls().setShowCatName(ctboolean);
        ctBarChart.getPlotArea().getBarChartArray(0).getDLbls().setShowLeaderLines(ctboolean);
        ctBarChart.getPlotArea().getBarChartArray(0).getDLbls().setShowBubbleSize(ctboolean);

        //val axis maximum:
        ctBarChart.getPlotArea().getValAxArray(0).getScaling().addNewMax().setVal(100);

        //cat axis title:
        ctBarChart.getPlotArea().getCatAxArray(0).addNewTitle().addNewOverlay().setVal(false);
        ctBarChart.getPlotArea().getCatAxArray(0).getTitle().addNewTx().addNewRich().addNewBodyPr();
        ctBarChart.getPlotArea().getCatAxArray(0).getTitle().getTx().getRich().addNewP().addNewR().setT("School Year");

        //series colors:
        ctBarChart.getPlotArea().getBarChartArray(0).getSerArray(0).getSpPr().addNewSolidFill().addNewSrgbClr().setVal(new byte[]{0, 0, (byte) 255});
        ctBarChart.getPlotArea().getBarChartArray(0).getSerArray(1).getSpPr().addNewSolidFill().addNewSrgbClr().setVal(new byte[]{0, (byte) 255, 0});

        FileOutputStream fileOut = new FileOutputStream("BarChart.xlsx");
        wb.write(fileOut);
        wb.close();
    }
}