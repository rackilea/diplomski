public static boolean fourInALine(boolean[][] arr, int index2)
{
  for (int j = 0; j <= arr.length - 4; j++) {
    boolean allSame = true;
    boolean firstValue = arr[j][index2];
    for (int i = 1; allSame && i < 4; i++) {
      allSame = (arr[j+i][index2] == firstValue);
    }
    if (allSame) return true;
  }
  return false;
}    ...
// used like:
if (fourInALine(wl, 0)) {
  System.out.println("WON");      
}