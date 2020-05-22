public void demoKey(String name, int index) throws IOException{

        FileInputStream fis = new FileInputStream("path");
        XSSFWorkbook workbook = new XSSFWorkbook(fis);

        XSSFSheet sheet = workbook.getSheet("Sheet1");
        Row row = sheet.createRow(index + 1);
        Cell cell = row.createCell(0);
        cell.setCellType(cell.CELL_TYPE_STRING);
        cell.setCellValue(name);
        FileOutputStream fos = new FileOutputStream("path");
        workbook.write(fos);
        fos.close();
    }
}