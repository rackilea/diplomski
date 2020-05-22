// inside init() method
boolean pass= Password.check(userInput);
Password mess= new Password();
passwordLabel.setText(mess.getDisplay(pass)); // passing the boolean to the getDisplay method
...
// getDisplay method.
public String getDisplay(boolean result) {
    return result ? "The Password meets the requirements" : "Your password does not match the requirements";
}