int userInput = 1; // Set default initialisation. 
String userInput1 = "";

try {
  NumberFormat.getInstance().parse(userInput1);
  userInput = Integer.parseInt(userInput1);
}
catch(ParseException e) {
  inputError = true; //not a number
}