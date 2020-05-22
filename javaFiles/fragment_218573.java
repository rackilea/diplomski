int lastColumn=0;
for (int rowNum = 0; rowNum < rowEnd; rowNum++){
    Row row=sheet1.getRow(rowNum);
    //need to check the rows that it should not be null
    if(row!=null)
        lastColumn = row.getLastCellNum();
    else
        continue;
    //check each cell for null or blank 
    for (int cn = 0; cn < lastColumn; cn++){
        Cell cell = row.getCell(cn, Row.RETURN_BLANK_AS_NULL);
        if(cell == null){
            break;
        }
           //Remaining code for non-blank cells
        }
}