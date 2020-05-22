Row row = sheet1.createRow((short)rowcounter);
                int lastColumn=6;
                for (int cn = 0; cn < lastColumn; cn++) {
                    Cell c = r.getCell(cn, Row.RETURN_BLANK_AS_NULL);
                    if (c == null){
                    }           
                    else if (c.getCellType() == HSSFCell.CELL_TYPE_STRING) {
                        Cell cell = row.createCell(cn);
                        cell.setCellValue(c.getStringCellValue());