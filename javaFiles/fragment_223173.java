public static void printCharRecur(char ch) {
 if(ch=='z') System.out.print("z z");
 else {
  System.out.print(ch);
  printCharRecur((char) (ch+1));
  System.out.print(ch);
 }
}