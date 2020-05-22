import com.google.common.collect.Lists;
import no.tollpost.web.termodash.rest.report.excel.model.ExcelReportDTO;
import no.tollpost.web.termodash.rest.report.excel.model.RowDTO;
import org.apache.poi.openxml4j.exceptions.OpenXML4JRuntimeException;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public final class ExcelGenerator {

  private ExcelGenerator() {
  }

  public static void getExcelVersion(final OutputStream outputStream) {
    try {
        final Workbook book = new XSSFWorkbook();
        generateReport(book);
        book.write(outputStream);
    } catch (final IOException | OpenXML4JRuntimeException e) {
        //log.warn("Failed to build excel report", e);
    }
  }

  private static void generateReport(final Workbook book) {
    final Sheet sheet = book.createSheet("Sheet_name);
    final List<String> columnNames = getColumnNames();
    final List<RowDTO> rows = getRows(getYourData()); // get your data as list of your DTOs

    generateTableHeader(sheet, book, columnNames);
    generateTableRows(sheet, rows);

    IntStream.range(0, columnNames.size()).forEach(sheet::autoSizeColumn);
  }

  private List<YourDTO> getYourData() {
  return // Your data as List (each element will be row in the excel sheet)
  }

  private static List<String> getColumnNames() {

    return Lists.newArrayList("column_name_1", "column_name_2", "column_name_3");
  }

  private static List<RowDTO> getRows(final List<YourDTO> data) {
        final List<RowDTO> rows = new ArrayList<>();
        IntStream.range(0, data.size()).forEach(i -> {
            final List<String> cellsMapper = new ArrayList<>();
            cellsMapper.add(data.get(i).getSomeProperty());
            cellsMapper.add(data.get(i).getOtherProperty());
            cellsMapper.add(data.get(i).getThirdProperty());
            cellsMapper.add(data.get(i).getFourthProperty());

            rows.add(new RowDTO(cellsMapper));
        });

        // rows.sort(Comparator.comparing(row -> row.getData().get(3)));

        return rows;
  }

  private static void generateTableHeader(final Sheet sheet, final Workbook workbook, final List<String> cellTitles) {
    final Row tabellHeader = sheet.createRow(0);

    IntStream.range(0, cellTitles.size()).forEach(cellNummer -> {
        final Cell cell = tabellHeader.createCell(cellNummer);
        cell.setCellValue(cellTitles.get(cellNummer));
        setHeaderCellStyle(cell, workbook, cellTitles.get(cellNummer));
    });
  }

  private static void setHeaderCellStyle(final Cell celle, final Workbook workbook, final String celleTittel) {
    if (!celleTittel.isEmpty()) {
        celle.setCellStyle(getHeaderCellStyle(workbook));
    }
  }

  private static CellStyle getHeaderCellStyle(final Workbook workbook) {
    final CellStyle style = workbook.createCellStyle();
    style.setFillForegroundColor(IndexedColors.PALE_BLUE.getIndex());
    style.setFillPattern(CellStyle.SOLID_FOREGROUND);
    final Font font = workbook.createFont();
    font.setBoldweight(Font.BOLDWEIGHT_BOLD);
    style.setFont(font);

    return style;
  }

  private static void generateTableRows(final Sheet sheet, final List<RowDTO> rows) {
    IntStream.range(0, rows.size()).forEach(rowNUmber -> {
        final Row row = sheet.createRow(rowNUmber + 1);

        IntStream.range(0, rows.get(rowNUmber).getData().size())
                 .forEach(cellNumber -> setCellValue(cellNumber, rowNUmber, row, rows));
    });
  }

  private static void setCellValue(final int cellNumber, final int rowNumber, final Row row, final List<RowDTO> rows) {
    final Cell cell = row.createCell(cellNumber);
    cell.setCellValue(rows.get(rowNumber).getData().get(cellNumber));
    cell.setCellType(Cell.CELL_TYPE_STRING);
  }
}

final class RowDTO {

    private final List<String> data;

    public RowDTO(final List<String> data) {
    this.data = data;
    }

    public List<String> getData() {
       return data;
   }
}