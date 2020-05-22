import java.io.FileOutputStream;
import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.*;


public class ForegroundColor {
    public static void main(String[] args) throws Exception {
        Workbook wb = new HSSFWorkbook();
        Sheet sheet = wb.createSheet();

        CellStyle estiloCabecera = wb.createCellStyle();
        estiloCabecera.setFillBackgroundColor(IndexedColors.BLACK.getIndex());
        estiloCabecera.setFillPattern(CellStyle.SOLID_FOREGROUND);

        Font fuenteCabecera = wb.createFont();
        fuenteCabecera.setFontHeightInPoints((short)12);
        fuenteCabecera.setFontName("Arial");
        fuenteCabecera.setColor((short)HSSFColor.WHITE.index);
        //fuenteCabecera.setColor(HSSFFont.COLOR_RED);
        estiloCabecera.setFont(fuenteCabecera);

        Row rowCabeceraTabla = sheet.createRow((short)3);
        Cell celda = rowCabeceraTabla.createCell(0);
        celda.setCellValue(new HSSFRichTextString("Id pregunta"));
        celda.setCellStyle(estiloCabecera);

        FileOutputStream fos = new FileOutputStream("color.xls"); 
        wb.write(fos);
        fos.close();
    }
}