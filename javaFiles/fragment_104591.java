//Commented both calls
//System.arraycopy(ltArray, 0, retArray, 0, ltArray.length);
//System.arraycopy(rtArray, 0, retArray, ltArray.length, rtArray.length);
for (int row = 0; row < ltArray.length; row++) {
    int colInTarget = 0;
    for (int col = 0; col < ltArray[row].length; col++,colInTarget++) {
        retArray[row][colInTarget] = ltArray[row][col];
    }
    for (int col = 0; col < rtArray[row].length; col++,colInTarget++) {
        retArray[row][colInTarget] = rtArray[row][col];
    }
}