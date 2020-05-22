static String generateValidNumber() {
    boolean validNumber = false;
    String newNumber = null;
    while(!validNumber) {
        // add this line
        newNumber = "";
        for(int i = 0; i < 4; i++) {
            char c = (char) ('0' + (Math.random() * 10));
            newNumber = newNumber + c;
        }
        if(isValidNumber(newNumber))
            validNumber = true;
    }
    return newNumber;
}