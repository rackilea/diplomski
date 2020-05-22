public static List<String> splitter(String input) {
    int nestingLevel=0;
    StringBuilder currentToken=new StringBuilder();
    List<String> result = new ArrayList<>();
    for (char c: input.toCharArray()) {
        if (nestingLevel==0 && c == '/') { // the character is a separator !
            result.add(currentToken.toString());
            currentToken=new StringBuilder();
        } else {
            if (c == '(') { nestingLevel++; }
            else if (c == ')' && nestingLevel > 0) { nestingLevel--; }

            currentToken.append(c);
        }
    }
    result.add(currentToken.toString());
    return result;
}