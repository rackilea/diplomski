String x = "F";
// Might be true, because the compiler will use ONE object 
// for both instances of "F". It's still bad and should not be done.
boolean isF = x == "F";

String y = new Scanner(System.in).nextLine();
// Will NEVER be true, even if you entered "F", because
//  y will always be a NEW String object...
isF = y == "F"; 
// Will be true, if you entered "F"
isF = "F".equals(y);