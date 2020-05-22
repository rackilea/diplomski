//instantiate the CLIParser 

CLIParser parser = new CLIParser("\"a b\" p q r \"x y z\"");

//call the method getTokens which gives you the result.

ArrayList<String> resultTokens = parser.getTokens();


###################CLI Parser Class definition#################################

class CLIParser {
    private String cmdString;

    public CLIParser(String cmdString) {
        this.cmdString = cmdString;
    }

    public ArrayList<String> getTokens() throws Exception {
        ArrayList<String> finalTokens = new ArrayList<String>();
        ArrayList<StringBuffer> tokens = new ArrayList<StringBuffer>();
    char inArray[] = this.cmdString.toCharArray();
    StringBuffer token = new StringBuffer();
    int valid = checkIfTheStringIsValid(inArray);
    if (valid == -1) {
        for (int i = 0; i <= inArray.length; i++) {

            if (i != inArray.length) {
                if ((inArray[i] != ' ') && (inArray[i] != '"')) {
                    token.append(inArray[i]);
                }

                if ((inArray[i] == '"') && (inArray[i - 1] != '\\')) {
                    i = i + 1;
                    while (checkIfLastQuote(inArray, i)) {
                        token.append(inArray[i]);
                        i++;
                    }
                }
            }
            if (i == inArray.length) {
                tokens.add(token);
                token = new StringBuffer();
            } else if (inArray[i] == ' ' && inArray[i] != '"') {
                tokens.add(token);
                token = new StringBuffer();
            }
        }
    } else {
        throw new InvalidCommandException(
                "Invalid command. Couldn't identify sequence at position "
                        + valid);
    }
    for(StringBuffer tok:tokens){
        finalTokens.add(tok.toString());
    }
    return finalTokens;
}

private static int checkIfTheStringIsValid(char[] inArray) {
    Stack myStack = new Stack<Character>();
    int pos = 0;
    for (int i = 0; i < inArray.length; i++) {
        if (inArray[i] == '"' && inArray[i - 1] != '\\') {
            pos = i;
            if (myStack.isEmpty())
                myStack.push(inArray[i]);
            else
                myStack.pop();
        }
    }
    if (myStack.isEmpty())
        return -1;
    else
        return pos;
}

private static boolean checkIfLastQuote(char inArray[], int i) {
    if (inArray[i] == '"') {
        if (inArray[i - 1] == '\\') {
            return true;
        } else
            return false;
    } else
        return true;
}
}