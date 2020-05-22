public static void main(String[] args) {
  int i,j;
  String key;
  String[] inputArray = {"E","D","C","B","A","B"};
  System.out.println(Arrays.toString(inputArray));
  for (j = 1; j < inputArray.length; j++) { //the condition has changed
    key = inputArray[j];
    i = j - 1;
    while (i >= 0) {
      if (key.compareTo(inputArray[i]) > 0) {//here too
        break;
      }
      inputArray[i + 1] = inputArray[i];
      i--;
    }
    inputArray[i + 1] = key;
    System.out.println(Arrays.toString(inputArray));
  }
  System.out.println(Arrays.toString(inputArray));
}