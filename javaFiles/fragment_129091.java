public static void main(String[] args) {

  String octalString = "150 145 154 154 157 40 167 157 162 154 144";

  StringTokenizer tokeniser = new StringTokenizer(octalString);
  int len = tokeniser.countTokens();
  int[] octalArray = new int[len];
  byte[] octalByteArray = new byte[len];

  for (int i = 0; tokeniser.hasMoreTokens(); i++) {
    octalArray[i] = Integer.parseInt(tokeniser.nextToken(),8);
    octalByteArray[i] = (byte) octalArray[i];
  }
  System.out.println(new String(octalByteArray, "UTF-8"));
}