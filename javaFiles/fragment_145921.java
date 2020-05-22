import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.RichTextString;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import address.Class1;
import address.Class2;

public class CreateTable {

public void newTableCompare(Class1 class1, Class1 class2,
        ReportDcResultViewDto resultDto, OutputStream outputStream)
        throws FileNotFoundException, IOException {

    Workbook wb = new XSSFWorkbook();

    XSSFSheet sheet = (XSSFSheet) wb.createSheet();
    int rowCount = 1;
    int columnCount = 7;
    ArrayList<String> columnNames = new ArrayList<String>();

    columnNames.add("filename");
    columnNames.add("type");
    columnNames.add("created by");
    columnNames.add("modified by");
    columnNames.add("modification date");
    columnNames.add(class1.getName());
    columnNames.add(class2.getName());

    CreationHelper creationHelper = wb.getCreationHelper();
    // Create
    XSSFRow rowHeader = sheet.createRow(0);
    for (int j = 0; j < columnCount; j++) {
        // create first row
        XSSFCell cell = rowHeader.createCell(j);
        RichTextString richString = creationHelper
                .createRichTextString(columnNames.get(j));
        Font font = wb.createFont();
        font.setBold(true);
        richString.applyFont(font);

        cell.setCellValue(richString);
        CellStyle style = wb.createCellStyle();
        style.setFont(font);

        cell.setCellStyle(style);
    }

    if (CollectionUtils.isNotEmpty(resultDto
            .getClass1ExclusiveViewDtos())) {
        for (ReportDcResultViewExclusiveDto dto : resultDto
                .getClass1ExclusiveViewDtos()) {

            XSSFRow row = sheet.createRow(rowCount);
            for (int j = 0; j < columnCount; j++) {
                XSSFCell cell = row.createCell(j);

                    switch (j) {
                    case 0:
                        cell.setCellValue(dto.getFile().getFilename());
                        break;
                    case 1:
                        cell.setCellValue(dto.getFile().getType()
                                .toString());
                        break;
                    case 2:
                        cell.setCellValue(dto.getFile().getCreatedBy()
                                .getUsername());
                        break;
                    case 3:
                        cell.setCellValue(dto.getModification().getUser()
                                .getUsername());
                        break;
                    case 4:
                        cell.setCellValue(dto.getModification().getDate().toString());
                        break;
                    case 5:
                        cell.setCellValue("yes");
                        break;
                    case 6:
                        cell.setCellValue(" ");
                        break;
                    default:
                        cell.setCellValue("Missing");
                        break;
                    }
                }
                rowCount++;
            }
        }
        for (int k = 0; k < columnCount; k++) {
            sheet.autoSizeColumn(k);
    }
    System.out.println("check rowCount: current="+rowCount);
    wb.write(outputStream);
    outputStream.close();
    wb.close(); 
}
}