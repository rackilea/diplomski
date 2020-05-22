String a = "234 - 456";
String[] strings = a.split(" - ");
// Then you can parse them
// You may want to do a check here to see if the user entered real numbers or not
// This is only needed for user input, if the numbers are hard coded you don't need this, although it doesn't hurt to have it
int firstNumber = 0; // Assign them before hand so you can use them after the try catch
int secondNumber = 0;
try {
    firstNumber = Integer.parseInt(strings[0]); // firstNumber becomes 234
    secondNumber = Integer.parseInt(strings[1]); // secondNumber becomes 456
} catch(NumberFormatException e) { 
    System.out.println("Please enter real numbers!");
}