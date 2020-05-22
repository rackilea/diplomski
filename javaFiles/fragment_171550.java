public static String findAddressByName(String nameToSearch) {
        String fileLocation = "I:\\foo.xlsx";
        XSSFWorkbook wb = new XSSFWorkbook(new File(fileLocation));
        for (int sheetIndex = 0; sheetIndex < wb.getNumberOfSheets(); sheetIndex++) {
            XSSFSheet sheet = wb.getSheetAt(sheetIndex);
            for (int rowIndex = 0; rowIndex < sheet.getLastRowNum(); rowIndex++) {
                XSSFRow row = sheet.getRow(rowIndex);
                if (row != null && row.getCell(0).getStringCellValue().equals(nameToSearch)) {
                    return row.getCell(1).getRawValue();
                }
            }
        }
        return "";
    }