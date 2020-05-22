String line = // input line e.g. "Aliens$Bluray$true$John$Monday"
String[] strings = line.split("\\$"); // use regex matching "$" to split
String title = strings[0];
String formatt = strings[1];
boolean onLoan = Boolean.parseBoolean(strings[2]);
String loanedTo = strings[3];
String dateLoaned = strings[4];
// TODO: create object from those values