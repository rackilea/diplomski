public static void main(String[] args) throws Exception {
    _Application excelApplication = ClassFactory.createApplication();

_Workbook workbook = excelApplication
        .workbooks()
        .open("C:\\Users\\Akki\\Desktop\\MyExcel.xlsx",
                null, null, null, null,
                null, null, null,
                null, null, null, null, null,
                null, null, 0);

workbook.exportAsFixedFormat(XlFixedFormatType.xlTypePDF, "C:\\Users\\Akki\\Desktop\\MyPDF.pdf", null, null, null, null, null, null, null);

workbook.close(false, null,null, 0);

excelApplication.quit();

System.out.println("Converted Excel to PDF!"); }