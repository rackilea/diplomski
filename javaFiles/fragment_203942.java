String[][] errorcodesArray = new String[errorcodes.length][2];
for (int i = 0; i < errorcodes.length; i++) {
  StringTokenizer st = new StringTokenizer(
      errorcodes[i], "|");
  if (st.hasMoreTokens())
    errorcodesArray[i][0] = st.nextToken();
  if (st.hasMoreTokens())
    errorcodesArray[i][1] = st.nextToken();
}
for (int i = 0; i < errorcodesArray.length; i++) {
  System.out.println(Arrays
      .toString(errorcodesArray[i]));
}