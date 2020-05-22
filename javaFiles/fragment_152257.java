import com.google.common.collect.HashBasedTable;
import com.google.common.collect.Table;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.util.CellRangeAddress;

public class ExcelFormatting {

    public static void main(String[] args) throws IOException {
        FileInputStream file = new FileInputStream(new File("Data.xls"));
        HSSFWorkbook workbook = new HSSFWorkbook(file);
        HSSFSheet sheet = workbook.getSheetAt(0);
        // ABC - Range A3:F7 in Data.xls
        Table<Integer, Integer, String> abc = getValues(sheet, 2, 0, 6, 5);
        //displayTable(abc);
        // XYZ - Range A11:E14 in Data.xls
        Table<Integer, Integer, String> xyz = getValues(sheet, 10, 0, 13, 4);
        //displayTable(xyz);

        Table<Integer, Integer, String> results = HashBasedTable.create();
        // Headers
        results.put(0, 0, "Name");
        results.put(0, 1, "Section");
        results.put(0, 2, "Check");
        results.put(0, 3, "Cat");
        results.put(0, 4, "Value");
        // Process ABC table
        results.putAll(transform(abc, "ABC", results.rowMap().size()));
        // Process XYZ table        
        results.putAll(transform(xyz, "XYZ", results.rowMap().size()));
        displayTable(results);
    }


    private static Table<Integer, Integer, String> transform(Table<Integer, Integer, String> table, String section, int offset) {
        Table<Integer, Integer, String> results = HashBasedTable.create();
        int maxRows = table.rowMap().size();
        int maxCols = table.columnMap().size();
        // First col is Name
        String name;
        // Second col is Check
        String check;
        String catA, catB, catC, catD = null;
        // offset is added so that table putAll doesn't overlap data rather than append it
        int outputRow = 0 + offset;
        for (int r = 0; r < maxRows; r++) {
            name = table.get(r, 0);
            check = table.get(r, 1);
            if (check == null) {
                check = "";
            }
            catA = table.get(r, 2);
            catB = table.get(r, 3);
            catC = table.get(r, 4);
            if (maxCols == 6) {
                catD = table.get(r, 5);
            }
            if (catA != null) {
                results = addRow(results, outputRow, name, section, check, "A", catA);
                outputRow++;
            }
            if (catB != null) {
                results = addRow(results, outputRow, name, section, check, "B", catB);
                outputRow++;
            }
            if (catC != null) {
                results = addRow(results, outputRow, name, section, check, "C", catC);
                outputRow++;
            }
            if (catD != null) {
                results = addRow(results, outputRow, name, section, check, "D", catD);
                outputRow++;
            }
        }
        return results;
    }

    private static Table<Integer, Integer, String> addRow(Table<Integer, Integer, String> table, int row, String name, String section, String check, String category, String value) {
        table.put(row, 0, name);
        table.put(row, 1, section);
        table.put(row, 2, check);
        table.put(row, 3, category);
        table.put(row, 4, value);
        return table;
    }

    // Convert "merged" data into normal populated cells
    private static Table<Integer, Integer, String> getValues(Sheet sheet, int minRow, int minCol, int maxRow, int maxCol) {
        Table<Integer, Integer, String> table = HashBasedTable.create();
        String result;
        Row row;
        Cell col;
        int r = minRow;
        int c;
        while (r <= maxRow) {
            row = sheet.getRow(r);
            c = minCol;
            while (c <= maxCol) {
                col = row.getCell(c);
                result = getValue(sheet, row, col);
                if (result != null) {
                    table.put(r - minRow, c - minCol, result);
                }
                c++;
            }
            r++;
        }
        return table;
    }

    private static String getValue(Sheet sheet, Row row, Cell cell) {
        String result = getCellValue(cell);
        if (result == null) {
            result = getMergedAreaValue(sheet, row.getRowNum(), cell.getColumnIndex());
        }
        return result;
    }

    private static String getCellValue(Cell cell) {
        String result = null;
        if (Cell.CELL_TYPE_STRING == cell.getCellType()) {
            result = cell.getStringCellValue();
        }
        if (Cell.CELL_TYPE_NUMERIC == cell.getCellType()) {
            result = cell.getNumericCellValue() + "";
        }
        return result;
    }

    private static String getMergedAreaValue(Sheet sheet, int row, int col) {
        int mergedAreas = sheet.getNumMergedRegions();
        CellRangeAddress mergeArea;
        for (int i = 0; i < mergedAreas; i++) {
            mergeArea = sheet.getMergedRegion(i);
            if (mergeArea.isInRange(row, col)) {
                return getCellValue(
                        sheet.getRow(mergeArea.getFirstRow())
                        .getCell(mergeArea.getFirstColumn()));
            }
        }
        return null;
    }

    private static void displayTable(Table<Integer, Integer, String> table) {
        int maxRows = table.rowMap().size();
        int maxCols = table.columnMap().size();
        StringBuilder sb = new StringBuilder();
        String val;
        for (int r = 0; r < maxRows; r++) {
            for (int c = 0; c < maxCols; c++) {
                val = table.get(r, c);
                if (val != null) {
                    sb.append(val);
                }
                sb.append("\t\t");
            }
            sb.append('\n');
        }
        System.out.println(sb.toString());
    }


}