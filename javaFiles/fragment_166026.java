String str = "Hello World";
for (int i = 0; i < str.length(); i++) {
    String binStr = String.format("%8s", Integer.toBinaryString(str.charAt(i))).replace(' ', '0');

    int[] intArray = new int[binStr.length()];
    for (int j = 0; j < binStr.length(); j++) {
        intArray[j] = Integer.valueOf(String.valueOf(binStr.charAt(j)));

        // This also works 
        //intArray[j] = Character.getNumericValue(binStr.charAt(j));
    }
    System.out.println(Arrays.toString(intArray));
}