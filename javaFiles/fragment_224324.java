public class CommentStripper {
    private enum State {
        CODE,
        LINE_COMMENT,
        COMMENT,
        STRING
    }
    public static String strip(String input) {
        return strip(input.toCharArray());
    }

    public static String strip(char[] input) {
        State currentState = State.CODE;
        StringBuilder rv = new StringBuilder();
        char[] lineSeparator = System.lineSeparator().toCharArray();
        for (int i = 0; i < input.length; i++) {
            STATE_SWITCH: switch (currentState) {
            case CODE: 
                if (input[i] == '"') {
                    currentState = State.STRING;
                    rv.append(input[i]);
                    break;
                }
                if (input[i] == '/') {
                    if (i + 1 >= input.length) {
                        rv.append(input[i]);
                        break;
                    }
                    if (input[i+1] == '*') {
                        i++;
                        currentState = State.COMMENT;
                        break;
                    } else if (input[i+1] == '/') {
                        i++;
                        currentState = State.LINE_COMMENT;
                        break;
                    }
                }
                rv.append(input[i]);
            break;
            case STRING:
                if (input[i] == '"') {
                    currentState = State.CODE;
                    rv.append(input[i]);
                    break;
                }
                rv.append(input[i]);
                break;
            case COMMENT:
                if (input[i] == '*') {
                    if (i + 1 >= input.length) {
                        break;
                    }
                    if (input[i + 1] == '/') {
                        i++;
                        currentState = State.CODE;
                        break;
                    }
                }
                break;
            case LINE_COMMENT:
                for (int sepIndex = 0; sepIndex < lineSeparator.length; sepIndex++) {
                    if (input[i+sepIndex] != lineSeparator[sepIndex]) {
                        break STATE_SWITCH;
                    }
                }
                i+=lineSeparator.length-1;
                rv.append(lineSeparator);
                currentState = State.CODE;
                break;
            } 
        }
        return rv.toString();
    }
}