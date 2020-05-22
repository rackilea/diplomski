for (Row row : sheet) 
    {
        for (Cell cell : row)
            {
                if (cell.getCellType() == Cell.CELL_TYPE_STRING) 
                    if (cell.getRichStringCellValue().getString().trim().equals(targetLetter))
                        row1= row.getRowNum();  
                if (cell.getCellType() == Cell.CELL_TYPE_STRING) 
                    if (cell.getRichStringCellValue().getString().trim().equals(displayLetter)) 
                        col1= cell.getColumnIndex();  
                c= sheet.getRow(row1).getCell(col1); // c is of type Cell
            }
    }