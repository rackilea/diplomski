String result;
Integer sum = 123;
int[] resultArray = new int[32];
Integer ii;
result = Integer.toBinaryString(sum);

    String[] temp = result.split("");
    ii = 0;
    for(String s: temp) {
      try {
        resultArray[ii++] = Integer.parseInt(s);
      } catch (NumberFormatException e) {
         // do nothing
      }
    }

    int n = ii;
    for (ii = 0; ii < n; ii++) {
      System.out.print(resultArray[ii]);
    }
    System.out.println();