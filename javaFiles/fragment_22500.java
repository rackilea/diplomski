String nums="1235325";
int[]  iArr = new int[nums.length ()];
for (int i = 0; i < nums.length (); i++) {
  iArr[i]=Character.getNumericValue (nums.charAt (i));
}
Arrays.sort (iArr);
System.out.println (Arrays.toString (iArr));