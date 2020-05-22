private  int getRowCount(Sheet currentSheet) {
        int rowCount = 0;
        Iterator<Row> rowIterator = currentSheet.iterator();

        while(rowIterator.hasNext()) {  
            Row row = rowIterator.next();

            if(row == null || row.getCell(0) == null || row.getCell(0).getStringCellValue().trim().equals("") || row.getCell(0).toString().trim().equals("") 
                    || row.getCell(0).getCellType()==Cell.CELL_TYPE_BLANK){
                break;
            }
            else
                rowCount=rowCount + 1;
        }       
        return rowCount;
    }