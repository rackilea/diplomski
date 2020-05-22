private void startParsing() {

     for (int i = 0; i < worksheet.getPhysicalNumberOfRows(); i++) {
             if (i == ROW_E || i == ROW_F) {
                mutateCell(worksheet.getRow(i));
            }
        }
}

private void mutateCell(final Row curRow) {
    for(int i=0;i<Oleo18_1.size();i++){    
    XSSFCell c = curRow.getCell((short) d); 
    if (c == null || c.getCellType() == Cell.CELL_TYPE_BLANK) {
        Oleo18_1.set(i, false);
    } 
    else {
        Oleo18_1.set(i, true);
        c.setCellType(Cell.CELL_TYPE_STRING);
    }

    if(Oleo18_1.get(i) == true){
        values_18_1.set(i, 9.09090909);
    }

    String a1Val = c.getStringCellValue();
    System.out.println("valor ponderacion"+(d+1)+": "+values_18_1.get(i));
    System.out.println("valor celda "+(d+1)+": "+a1Val);

    d++;  

     }                        
}