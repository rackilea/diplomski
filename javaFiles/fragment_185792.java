for (int rowNum = 0; rowNum < sheet.getLastRowNum() + 1; rowNum++) {
        ArrayList<String> al = new ArrayList<String>();
        String val = null;

        Row r = sheet.getRow(rowNum);

        for (int i = 0; i < r.getLastCellNum() + 1; i++) {
            Cell cell = r.getCell(i);
            val = formatter.formatCellValue(cell);
            al.add(val);
        }

        mainArrayList.add(al);
    }