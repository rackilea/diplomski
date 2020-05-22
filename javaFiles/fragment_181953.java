public static File createExcelWorkbookPosition(String BsnsDate) throws Exception {  
    File file = new File("workbook.xlsx");
    FileOutputStream out = new FileOutputStream(file);
    // ...  
    return file;
}