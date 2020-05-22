// Please use sensible names for your variables, and no uppercase single letters
double height = Double.parseDouble(heightField.getText()); // This could throw a NumberFormatException, you probably want to catch it
String backIssues = backField.getText();
String heartIssues = heartField.getText();

// Drop your first if test, it is completely unnecessary there.

// If the person is between 122 and 188 cm, and has no heart issues and has no back issues: Hooray!
if (height >= 122 && height <= 188 && heartIssues.equalsIgnoreCase("N") && backIssues.equalsIgnoreCase("N")) {
  output.setText("You are cleared to ride, have fun!");
} else { // In all other cases, not allowed to ride the coaster
  output.setText("Sorry, its not safe for you to ride the coaster");
}