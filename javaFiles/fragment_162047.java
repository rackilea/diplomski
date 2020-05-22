import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
//..
FileInputStream file = new FileInputStream(new File("C:\\test.xls"));

//Get the workbook instance for XLS file 
HSSFWorkbook workbook = new HSSFWorkbook(file);

//Get first sheet from the workbook
HSSFSheet sheet = workbook.getSheetAt(0);

//Get iterator to all the rows in current sheet
Iterator<Row> rowIterator = sheet.iterator();

//Get iterator to all cells of current row
Iterator<Cell> cellIterator = row.cellIterator();