private void excelReader() {
    String data;
    try {
        InputStream is = new FileInputStream("Read.xlsx");
        Workbook wb = WorkbookFactory.create(is);
        Sheet sheet = wb.getSheetAt(0);
        Iterator rowIter = sheet.rowIterator();
        Row r = (Row)rowIter.next();
        short lastCellNum = r.getLastCellNum();
        int[] dataCount = new int[lastCellNum];
        int col = 0;
        rowIter = sheet.rowIterator();
        while(rowIter.hasNext()) {
            Iterator cellIter = ((Row)rowIter.next()).cellIterator();
            while(cellIter.hasNext()) {
                Cell cell = (Cell)cellIter.next();
                col = cell.getColumnIndex();
                dataCount[col] += 1;
                DataFormatter df = new DataFormatter();
                data = df.formatCellValue(cell);
                System.out.println("Data: " + data);
            }
        }
        is.close();
        for(int x = 0; x < dataCount.length; x++) {
            System.out.println("col " + x + ": " + dataCount[x]);
        }
    }
    catch(Exception e) {
        e.printStackTrace();
        return;
    }
}