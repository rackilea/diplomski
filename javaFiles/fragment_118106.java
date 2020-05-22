private void printToConsole(List cellDataList) {
        for (int i = 0; i < cellDataList.size(); i++) {
            List cellTempList = (List) cellDataList.get(i);
            if((HSSFCell) cellTempList.get(2).toString().equals("1"))
            {
            for (int j = 0; j < cellTempList.size(); j++) {

                HSSFCell hssfCell = (HSSFCell) cellTempList.get(j);
                String stringCellValue = hssfCell.toString();

                System.out.print(stringCellValue + "\t");
            }
            }
            else { 
             i++;
            }
            System.out.println();
        }
    }