package stackoverflow.q59892610;

import org.junit.Rule;
import org.junit.Test;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.rules.TemporaryFolder;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.UUID;

import static org.apache.poi.xssf.usermodel.XSSFWorkbookType.XLSX;
import static org.junit.Assert.*;

public class PoiTest
{
    @Rule
    public TemporaryFolder folder= new TemporaryFolder(new File("target"));
    @Test
    public void xlsTest() throws Exception
    {
        File file = new File(folder.getRoot(), UUID.randomUUID() + ".xlxs");
        String cellValue = UUID.randomUUID().toString();
        try (XSSFWorkbook xls = new XSSFWorkbook(XLSX)) {
            xls.createSheet("new sheet").createRow(0).createCell(0).setCellValue(cellValue);
            try(OutputStream out = new FileOutputStream(file)) {xls.write(out);}
        }
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        XSSFWorkbook xls = new XSSFWorkbook(file);
        XSSFSheet worksheet = xls.getSheetAt(0);
        assertEquals("cell value mismatch", cellValue, worksheet.getRow(0).getCell(0).getStringCellValue());
    }
}