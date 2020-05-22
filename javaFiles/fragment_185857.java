I figured it out.

private static String getNextRow(XSSFSheet sheet, String cellContent) {
        Iterator<Row> itr = sheet.iterator();
        while (itr.hasNext()) {
            Row row = itr.next();
            Iterator<Cell> cellIterator = row.cellIterator();
            while (cellIterator.hasNext()) {
                Cell cell = cellIterator.next();
                if (cell.getCellType() == Cell.CELL_TYPE_STRING) {
                    if (cell.getRichStringCellValue().getString().trim()
                            .equals(cellContent)) {
                        row = itr.next();
                        int val = cell.getColumnIndex();
                        cell = row.getCell(val);
                        String srow = cell.getStringCellValue();
                        return srow;

                    }

                }

            }
        }

        return null;
    }