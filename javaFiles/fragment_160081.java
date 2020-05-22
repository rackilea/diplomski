private static final String FILE_NAME = "D:/test_out.xls";
private static final String SHEET_NAME = "Test sheet name";
private static final int SHEET_INDEX = 0;
private static final String HEADER = "My header";

public static void main(String[] args) throws Exception {
    WritableWorkbook writableWorkbook = Workbook.createWorkbook(new File(FILE_NAME));
    WritableSheet writableSheet = writableWorkbook.createSheet(SHEET_NAME, SHEET_INDEX);

    int columnIndex = 0;
    int rowIndex = 0;

    writableSheet.addCell(new Label(columnIndex, rowIndex, HEADER));

    for (String value : Arrays.asList("First value", "Second value", "Another value")) {
        writableSheet.addCell(new Label (columnIndex, ++rowIndex, value));
    }

    writableWorkbook.write();
    writableWorkbook.close();
}