import java.io.File;
import java.io.IOException;

import jxl.Cell;
import jxl.CellType;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

public class ReadExcell {
public static void main(String[] args) {
ReadExcell.ExcelFile("D:\\rptViewer.xls");
}

/*
* Read excel file using j excel file
*/
public static String ExcelFile(String path){
StringBuilder excelContent = new StringBuilder();

try
{
Workbook workbook = Workbook.getWorkbook(new File(path));
Sheet sheet = workbook.getSheet(0);

excelContent = new StringBuffer();

for(int rows = 0 ; rows < sheet.getRows() ; rows++){
StringBuffer row = new StringBuffer();
for(int colums = 0 ; colums < sheet.getColumns() ;colums++){
  Cell cell = sheet.getCell(colums, rows);
if(cell.getType() == CellType.LABEL){
row.append(cell.getContents()+ ",");
}else
if(cell.getType() == CellType.NUMBER){
row.append(cell.getContents()+ ",");
}
}

excelContent.append(row.toString());
System.out.println(row.toString());
}

} catch (BiffException e) {
e.printStackTrace();
} catch (IOException e) {
e.printStackTrace();
}    

return excelContent.toString();
}
}