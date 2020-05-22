String intNumber = s.next();
try {
    return Integer.parseInt(intNumber);
catch(NumberFormatException e) { // catch system's exception
    // throw new one with your message
    throw new NumberFormatException("can't make an int");
}