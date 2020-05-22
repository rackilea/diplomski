String regex = "[0-9, /,]+";

// Negative test cases, should all be "false"
System.out.println("1234,234,345a".matches(regex)); //incorrect, So False will be print
     // positive test cases, should all be "true"
  System.out.println("1234,234,34".matches(regex)); //Correct, So True will be print