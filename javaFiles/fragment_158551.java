// inside init() method
boolean pass= Password.check(userInput);
// static method, hence mess object is not required.
passwordLabel.setText(Password.getDisplay(pass)); // passing the boolean to the getDisplay method
...
// getDisplay method.
public static String getDisplay(boolean result) { // static method
    return result ? "The Password meets the requirements" : "Your password does not match the requirements";
}