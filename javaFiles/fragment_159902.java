String s = "1234";
int[] intArray = new int[s.length()];

for (int i = 0; i < s.length(); i++) {
   intArray[i] = s.charAt(i) - '0';
}
System.out.println(Arrays.toString(intArray));