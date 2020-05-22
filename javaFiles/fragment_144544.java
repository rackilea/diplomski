String userInput = UserInput.getText();
String output = userInput + "=";
for (int i = 0; i < userInput.length(); i++) {
    int castAscii = (int) userInput.toCharArray()[i];
    output  += castAscii;
    if (i < userInput.length()) {
        output += ",";
    } 
}
DisplayText.setText(output);