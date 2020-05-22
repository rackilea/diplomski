Sheet sheet = workbook.getSheetAt(0);
    for(int i=0; i<sheet.getRow(sheet.getTopRow()).getLastCellNum(); i++){
        Iterator<Row> rowIterator=sheet.rowIterator();
        while(rowIterator.hasNext()){
            System.out.println(rowIterator.next().getCell(i)); //do what you want

        }

    }