import java.io.FileInputStream;
import java.io.InputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class App {

    public static void main(String[] args) {
        Workbook wb = null;
        InputStream inp = null;
        try {
            // InputStream inp = new FileInputStream("workbook.xls");
            inp = new FileInputStream("workbook.xlsx");
            wb = WorkbookFactory.create(inp);
            Sheet sheet = wb.getSheetAt(0);
            for (Row row : sheet) {
                for (Cell cell : row) {
                    System.out.println(getCellValue(cell));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try { if(wb != null) wb.close(); } catch (Exception e) {}
            try { if(inp != null) inp.close(); } catch (Exception e) {}
        }
    }

    private static Object getCellValue(Cell cell) {
        switch(cell.getCellType()) {
        case Cell.CELL_TYPE_STRING :
            return cell.getStringCellValue();
        case Cell.CELL_TYPE_NUMERIC : 
            return cell.getNumericCellValue();
        case Cell.CELL_TYPE_BOOLEAN : 
            return cell.getBooleanCellValue();
        case Cell.CELL_TYPE_ERROR : 
            return cell.getErrorCellValue();
        case Cell.CELL_TYPE_FORMULA : 
            return cell.getCellFormula();
        case Cell.CELL_TYPE_BLANK :
            return null;
        default : 
            return null;
        }
    }
}