public class DailyFile {
    int i = 0;

    private WritableCellFormat arialBold;
    private WritableCellFormat arial;
    private String inputFile;

    public DailyFile(String inputFile) {
        this.inputFile = inputFile;
    }

    public void write(int sheetCount) throws IOException, WriteException {
        // Step 1: Initialization
        File file = new File(inputFile);

        WorkbookSettings wbSettings = new WorkbookSettings();
        wbSettings.setLocale(new Locale("en", "EN"));

        WritableWorkbook workbook = Workbook.createWorkbook(file, wbSettings);

        // Step 2: Main logic
        for (int index = 0; index < sheetCount; index++) {
            WritableSheet excelSheet = workbook.createSheet(finalGui.ExperimentCodeList.get(index).toString(), index);
            createLabel(excelSheet);
            // createContent(excelSheet);
        }

        // Step 3: Closing
        workbook.write(); // <-- maybe in the loop?
        workbook.close();
    }

    public static void main(String[] args) throws WriteException, IOException {
        DailyFile test = new DailyFile("c:/Users/sbutler/Desktop/CERES_Daily-BLIND_TEST.xls");
        System.out.println("I RAN!");
        test.write(finalGui.ExperimentCodeList.size());
        System.out.println(sheetCounter);
        System.out.println("Please check the result file under c:/Users/sbutler/Desktop/CERES_Daily-BLIND_TEST.xls ");
    }
}