if (objArr[1] != null) {
                value = objArr[1].toString();
                myCell = myRow.createCell(1);
                myCell.setCellValue(value);
                myCell.setCellStyle(style);
            }

            rowNum++;
        }