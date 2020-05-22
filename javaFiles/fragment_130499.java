string[] temp = result.toCharArray();
ii = 0;
for(char s: temp) {
        resultArray[ii++] = s - '0';
}
int n = ii;
for (ii = 0; ii < n; ii++) {
      System.out.print(resultArray[ii]);
}