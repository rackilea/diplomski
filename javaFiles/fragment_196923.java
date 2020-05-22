if (objArr[0] != null) {
                header = objArr[0].toString();

                myRow = sheet.createRow((short) rowNum);
                myCell = myRow.createCell(0);



                for (int i = 0; i < 2; i++) {
                    Cell columnHeaderCell = myRow.createCell(i);
                    columnHeaderCell.setCellValue("");
                    columnHeaderCell.setCellStyle(style);   
                }
    }