for (Sheet sheet : workbook){
    System.out.println(sheet.getSheetName());
    for (Row r : sheet) {
        for (Cell c : r) {
            System.out.println(c.getStringCellValue());
        }
    }
}