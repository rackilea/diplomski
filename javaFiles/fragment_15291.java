int[][] myTable = new int[5][4];
for (int i = 0; i < myTable.length; i++) {
    for (int j = 0; j < myTable[i].length; j++) {
        System.out.println("Type a number:");
        myTable[i][j] = Integer.parseInt(mVHS.readLine());
    }
}