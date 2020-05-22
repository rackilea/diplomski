for (int[] row : imgMap) {
    String[] rowArray = mapBR.readLine().split(",");
    for (int c = 0; c < row.length; c++) {
        row[c] = Integer.parseInt(rowArray[c]);            
    }
}