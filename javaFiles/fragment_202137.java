public static void printSheetData(List<List<HSSFCell>> sheetData) {
    StringBuilder strBuilder = new StringBuilder();
    for (int i = 0; i < sheetData.size(); i++) {
        List<HSSFCell> list = (List<HSSFCell>) sheetData.get(i);
        for (int j = 0; j < list.size(); j++) {
            HSSFCell cell = (HSSFCell) list.get(j);
            // System.out.print(cell.toString());
            strBuilder.append(cell.toString());
            if (j < list.size() - 1) {
                // System.out.print(", ");
                strBuilder.append(", ");
            }
        }
        // System.out.println("");
        strBuilder.append("\n");

        // consider testing strBuilder size here and printing it out if
        // it is greater than some pre-set, then re-initializing the 
        // strBuilder variable.
    }
    System.out.println(strBuilder.toString());
}