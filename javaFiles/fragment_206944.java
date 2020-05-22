int lastColumn=0;
    for (int rowNum = 0; rowNum < rowEnd; rowNum++){
        Row row=sheet1.getRow(rowNum);
        if(row!=null)
            lastColumn = row.getLastCellNum();
        else
            continue;
        for (int cn = 0; cn < lastColumn; cn++){
            Cell cell = row.getCell(cn, Row.RETURN_BLANK_AS_NULL);
            if(cell == null){
                break;
            }
            switch(cell.getCellType()){
               //Remaining code for non-blank cells
            }
        }
    }