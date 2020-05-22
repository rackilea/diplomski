public static Sheet getSheet() throws BiffException, IOException {
    WorkbookSettings ws = new WorkbookSettings();
    ws.setLocale(new Locale("en", "EN"));
    Workbook w = Workbook.getWorkbook(new File(inputFile),ws);
    Sheet s = w.getSheet(0);
    return s;
}