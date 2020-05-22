public static String binaryform(int number) {

   String rest = "";

   while (number > 0) {
       rest = number%2 + rest;
       number = number/2;

   }

  //number = Integer.parseInt(rest); Commented it
  return rest;
}