outFile = new File("/myfiles", "table1.xlsx");
try (FileOutputStream fileOut = new FileOutputStream(outFile)) {
    InputStream is = getClass().getResourceAsStream("/com/myapp/templates/template1.xlsx");
    Workbook wb = new XSSFWorkbook(is);
    Sheet sheet = wb.getSheetAt(0);
    // Now populate the table here as your application requires
    wb.write(fileOut);
}