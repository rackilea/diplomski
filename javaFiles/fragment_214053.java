public static int getMaxColumnNum(HSSFSheet ws) {
    int rowNum = ws.getLastRowNum() + 1;
    int max = 0;
    int temp = 0;
    for (int i = 0; i < rowNum; i++) {
        temp = ws.getRow(i).getLastCellNum();
        if (max < temp)
            max = temp;
    }
    return max;
}