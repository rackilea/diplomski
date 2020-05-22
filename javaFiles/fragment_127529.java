String string = "XXYY";
String oldString;
do {
  oldString = string;
  string = string.replaceAll("XY", "");
} while(!string.equals(oldString));
// string will now be ""