if (cell.getCellType() == 2 && cell.getCachedFormulaResultType() == 1) {
            logger.log(Level.DEBUG, "Formula returns a string. (1)");
            cell.setCellType(Cell.CELL_TYPE_STRING);
            String value = cell.getStringCellValue();
            buffer.write(value.getBytes(charset));
        } else if (cell.getCellType() == 0 || cell.getCellType() == 2) {