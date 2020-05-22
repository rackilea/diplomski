private static int generateNumber(String str){
  if(str.length() == 3) {

    char fisrtChar = str.charAt(0);
    char secondChar = str.charAt(1);
    char thirdChar = str.charAt(2);

    int firstInt = CHARACTERS.indexOf(fisrtChar) * BASE * BASE; 
    int secondInt = CHARACTERS.indexOf(secondChar) * BASE;
    int thirdInt = CHARACTERS.indexOf(thirdChar);

    return firstInt + secondInt + thirdInt + 1;
  }
  return 0;
}