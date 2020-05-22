static void luhn(){
  System.out.print("Enter number to validate:\n");
  String pnr = input.nextLine();
  // this only works if you are certain all input will be at least 10 characters
  int extraChars = pnr.length() - 10;
  if (extraChars < 0) {
    throw new IllegalArgumentException("Number length must be at least 10 characters!");
  }
  pnr = pnr.substring(extraChars, 10 + extraChars);
  int sum = 0;
  // #3: removed pos
  for (int i = 0; i < pnr.length(); i++){
    char tmp = pnr.charAt(i);
    // #1: fixed the '0' problem
    int num = tmp - '0';
    int product;
    if (i % 2 != 0){
      product = num * 1;
    }
    else{
      product = num * 2;
    }
    if (product > 9)
      product -= 9;
    sum+= product;              
  }
  // #2: moved check outside for loop
  boolean valid = (sum % 10 == 0);
  if (valid){
    System.out.print("Valid!\r");
  }
  else{
    System.out.print("Invalid!");
  }
}