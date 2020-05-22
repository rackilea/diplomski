String intNumber = s.next();
if (intNumber.matches("-?\\d+")) { // see: regular expressions
    return Integer.parseInt(intNumber);
} else {
    throw new NumberFormatException("can't make an int");
}