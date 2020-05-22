Workbook workbook = WorkbookFactory.create(new File("c:/test.xls");
    Sheet marksSheet = (Sheet) workbook.getSheet("Sheet1");
            int zoneLastCount = 0;
            if(marksSheet !=null ) {
                zoneLastCount = getRowCount(marksSheet);
            }
    int zone = zoneLastCount-1;
    int column=1

    for(int i = 0; i < zone; i++) {         
        Row currentrow = marksSheet.getRow(i);
        double year = Double.parseDouble(currentrow.getCell(columnno).toString());
        int year1 = (int)year;
        String str = String.valueOf(year1);
    }