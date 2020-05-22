StringBuilder result = new StringBuilder(input.length());
    for (int ix = 0; ix < input.length(); ix++) {
        char ch = input.charAt(ix);
        if (endsWith(ch, result)) {
            removeLastChar(result);
        } else {
            result.append(ch);
        }
    }
    String output = result.toString();