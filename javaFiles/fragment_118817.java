public class ExcelReaderActivity extends AppCompatActivity {

    public static final String SAMPLE_XLSX_FILE_PATH = "/home/saeid/Documents/ABBREV.xlsx";
    public static final Map<String, String> numberDescMap = new HashMap<>();

    public final TextView productInput ;
    public final TextView productName;
    public final Button checkInput ;
    public final Button addInput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.reader_excel);
        productInput = findViewById(R.id.textView_InputProductNumber);
        productName = findViewById(R.id.textView_ProductName);
        checkInput = findViewById(R.id.button_GO);
        addInput = findViewById(R.id.button_AddProduct);
        createWorkbook();
    }


    createWorkbook(){

        // Creating a Workbook from an Excel file (.xls or .xlsx)
        Workbook workbook = WorkbookFactory.create(new File(SAMPLE_XLSX_FILE_PATH));

        // Retrieving the number of sheets in the Workbook
        System.out.println("Workbook has " + workbook.getNumberOfSheets() + " Sheets : ");

        // obtain a sheetIterator and iterate over it
        Iterator<Sheet> sheetIterator = workbook.sheetIterator();
        System.out.println("Retrieving Sheets using Iterator");
        while (sheetIterator.hasNext()) {
            Sheet sheet = sheetIterator.next();
            System.out.println("=> " + sheet.getSheetName());
        }

        // Getting the Sheet at index zero
        Sheet sheet = workbook.getSheetAt(0);
        Row rowCount = sheet.getRow(0);
        int totalNumberOfRows = sheet.getPhysicalNumberOfRows();
        int totalNumberOfColumns = rowCount.getPhysicalNumberOfCells();
        System.out.print("number of rows => " + totalNumberOfRows + "\n");
        System.out.print("number of columns => " + totalNumberOfColumns + "\n");

        // Create a DataFormatter to format and get each cell's value as String
        DataFormatter dataFormatter = new DataFormatter();

        // obtain a rowIterator and columnIterator and iterate over them
        System.out.println("\n\nIterating over Rows and Columns using Iterator\n");
        Iterator<Row> rowIterator = sheet.rowIterator();

        for (int currentRow = 1; currentRow < totalNumberOfRows; currentRow++){
            Row row = rowIterator.next();
            row = sheet.getRow(currentRow);
            Cell cell0 = row.getCell(0);
            Cell cell1 = row.getCell(1);
            String cellValue0 = dataFormatter.formatCellValue(cell0);
            String cellValue1 = dataFormatter.formatCellValue(cell1);
            numberDescMap.put(cellValue0,cellValue1);
            //System.out.print(currentRow + "-  *" + dbNumbers + "*" +  "*" + description + "*" + "\n");
        }

        List<String> dbNumbers = new ArrayList(numberDescMap.keySet());
        List<String> description = new ArrayList(numberDescMap.values());

        int checkIndex = 1;
        for (String mapkeys : dbNumbers){
            System.out.println(checkIndex++ + "- " + mapkeys + "==>" +numberDescMap.get(mapkeys) + "\n");
        }

        // Closing the workbook
        workbook.close();
    }
}