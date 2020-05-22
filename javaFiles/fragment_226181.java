Workbook workbook = WorkbookFactory.create(yourFile.getInputstream());

 Sheet sheet = workbook.getSheet(0);//1,2,3

 Iterator<Row> rowIterator = sheet.iterator();

        while (rowIterator.hasNext()) {

            Row row = rowIterator.next();

            row.getCell(0);
            row.getCell(1);
}