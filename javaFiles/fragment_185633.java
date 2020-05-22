int count = 0;
for (int i = 0; i < A.length; i ++) {
    int rowCount = 0;
    for(int j = 0; j < A[i].length; j++) {
        if (A[i][j] == 1) {
            rowCount++;
        }
    }
    if (rowCount > 2) {
        count++;
    }
}
System.out.println(count);