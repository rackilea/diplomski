public static void main(String []args){

// removed the early declarations here. This is C-style, old, unnecessary and makes 
// code harder to read

// ***** input box 1 ***** HARCODED - replace with UI call
String height1 = "6 10"; 

// ***** input box 2 ***** HARCODED - replace with UI call
String height2 = "3 10"; 

// ***** parse feet and inches from each input ***** 

String feet1 = height1.substring(0, 1);        // get the first digit
String inches1 = height1.substring(2, 4);      // get the last 2 digits

String feet2 = height2.substring(0, 1);        // get the first digit
String inches2 = height2.substring(2, 4);      // get the last 2 digits

// convert parsed string data to their integer counterparts
int f1 = Integer.parseInt(feet1);
int i1 = Integer.parseInt(inches1);

int f2 = Integer.parseInt(feet2);
int i2 = Integer.parseInt(inches2);

// calculate total feet
int totalFeet = f1 + f2 + (i1 + i2) / 12;

// calculate total inches (using modulus operator)
int totalInches = (i1 + i2) % 12;

// and do the output... assuming this is what you want...
System.out.println(totalFeet + " " + totalInches);
 }