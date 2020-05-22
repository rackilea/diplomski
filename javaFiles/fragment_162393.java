StringBuilder output = new StringBuilder();
boolean hasDigit = false;
boolean leadingZero = true;
for (int i = 0; i < str.length() && output.length() < 10; i++) {
    char currChar = str.charAt(i);
    if ('0' <= currChar && currChar <= '9') {
        hasDigit = true;
        if (currChar != '0') {
            output.append(currChar);
            leadingZero = false;
        } else if (!leadingZero) { // currChar == 0
            output.append(currChar);
        } // Ignore leading zero
    }
}

String result = !hasDigit ? "" :
                output.length() == 0 ? "0" :
                output.toString();