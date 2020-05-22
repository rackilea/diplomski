import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.util.CellUtil;

import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

public class TestIndexedColors {

    public static void main(String[] args) throws Exception {

        String templateName = "price-list-template.xlsx";
        InputStream inp = TestIndexedColors.class.getClassLoader().getResource(templateName).openStream();
        Workbook workbook = WorkbookFactory.create(inp);
        Sheet sheet = workbook.getSheetAt(0);

        Row row; Cell cell; int r = 11;
        Map<String,Object> cellProps;
        for (IndexedColors color : IndexedColors.values()) {
            row = sheet.createRow(r++);
            cell = row.createCell(0); cell.setCellValue(color.getIndex());
            cell = row.createCell(1); cell.setCellValue(color.name());
            cell = row.createCell(2);
            cellProps = new HashMap<>();
            cellProps.put(CellUtil.FILL_FOREGROUND_COLOR, color.getIndex());
            cellProps.put(CellUtil.FILL_PATTERN, FillPatternType.SOLID_FOREGROUND);
            CellUtil.setCellStyleProperties(cell, cellProps);
        }

        FileOutputStream out = new FileOutputStream("acme.xlsx"); 
        workbook.write(out);
        out.close();
        workbook.close();
    }
}