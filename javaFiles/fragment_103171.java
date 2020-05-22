public static void deleteRow(HSSFSheet sheet, Row row) {
            int lastRowNum = sheet.getLastRowNum();     
            if(lastRowNum !=0 && lastRowNum >0){
                int rowIndex = row.getRowNum();
                Row removingRow = sheet.getRow(rowIndex);
                if(removingRow != null){
                    sheet.removeRow(removingRow);
                     System.out.println("Deleting.... ");
                }    
        }
    }