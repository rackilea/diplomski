import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.ss.usermodel.Workbook;

...
...

// SS Workbook object
Workbook workbook;

// Handles both XSSF and HSSF automatically
workbook = WorkbookFactory.create(new FileInputStream(file)); 

//Do your parsing using the workbook object