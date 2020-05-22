String fileName = "/path/to/your/file/textFile.txt";
String excelFileName = "/path/to/your/file/excelFile.xlsx";

// Create a Workbook and a sheet in it
XSSFWorkbook workbook = new XSSFWorkbook();
XSSFSheet sheet = workbook.createSheet("Sheet1");

// Read your input file and make cells into the workbook
try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
    String line;
    Row row;
    Cell cell;
    int rowIndex = 0;
    while ((line = br.readLine()) != null) {
        row = sheet.createRow(rowIndex);
        String[] tokens = line.split("[|]");
        for(int iToken = 0; iToken < tokens.length; iToken++) {
            cell = row.createCell(iToken);
            cell.setCellValue(tokens[iToken]);
        }
        rowIndex++;
    }
} catch(Exception e) {
    e.printStackTrace();
}

// Write your xlsx file
try (FileOutputStream outputStream = new FileOutputStream(excelFileName)) {
    workbook.write(outputStream);
    workbook.close();
} catch (IOException e) {
    e.printStackTrace();
}