public String getUserName() {
    return userNameField.getText();
}

public int getDigit() {
    try {
        return Integer.parseInt(digitField.getText());
    } catch (NumberFormatException nfe) {
        nfe.printStackTrace();
    }
    return -1; //In case it's not a number, or return 0, or whatever you need
}

//------In another class------//

int digit = object1.getDigit(); //Where object1 is an instance of the other class where those methods are defined