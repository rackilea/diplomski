@PostMapping("/import")
public void mapReapExcelDatatoDB(@RequestParam("file") MultipartFile reapExcelDataFile) throws IOException {

   List<Test> tempStudentList = new ArrayList<Test>();
    XSSFWorkbook workbook = new XSSFWorkbook(reapExcelDataFile.getInputStream());
    XSSFSheet worksheet = workbook.getSheetAt(0);

    for(int i=1;i<worksheet.getPhysicalNumberOfRows() ;i++) {
        Test tempStudent = new Test();

        XSSFRow row = worksheet.getRow(i);

        tempStudent.setId((int) row.getCell(0).getNumericCellValue());
        tempStudent.setContent(row.getCell(1).getStringCellValue());
            tempStudentList.add(tempStudent);   
    }
}