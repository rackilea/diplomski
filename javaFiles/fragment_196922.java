int rowNum = 1;
Row myRow = null;
Row emptyRow = null;
Cell myCell = null;
Cell emptyCell =null;

for (Object obj : details) {
            Object[] objArr = (Object[]) obj;
            String header = "";
            String value = "";


            if(objArr[0]==null){
                emptyRow = sheet.createRow((short) rowNum);
                emptyCell = emptyRow.createCell(0);
                emptyCell.setCellValue("");
                emptyCell.setCellStyle(style);
            }

            if(objArr[1]==null){
                emptyCell = emptyRow.createCell(1);
                emptyCell.setCellValue(value);
                emptyCell.setCellStyle(style);
            }