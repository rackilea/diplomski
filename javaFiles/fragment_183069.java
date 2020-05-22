public class Parsy {
    enum State { string, comment, token }
    void parse(StringTokenizer tokenizer) {
        State state = State.token;

        List<String> tokens = new ArrayList<>();
        while (tokenizer.hasMoreTokens()) {
            String token = tokenizer.nextToken();
            // figure out type of token
            if (token.length() == 1) {
                char delim = token.charAt(0);
                switch (delim) {
                    case '$':
                        switch (state) {
                            case token: {
                                // a string literal has started, emit what we have, start a string
                                printOut(tokens, state);
                                tokens.clear();
                                tokens.add(token);
                                state = State.string;
                                break;
                            }
                            case string: { // parsing a string, so this ends it
                                printOut(tokens, state);
                                tokens.clear();
                                state = State.token;
                                break;
                            }
                            case comment: { // $ is ignored since we are in a comment
                                tokens.add(token);
                                break;
                            }
                        }
                        break;
                    // ...
                }
            } else {
                // not a delimiter token
                tokens.add(token);
            }

        } // end of while
    if (state != State.token) {
       System.out.println("Oops! Syntax error. I'm still parsing" + state);
     }
    }
}