public class TupleParser {

    /**
     * Not in use at the moment.
     */
    class TupleParserException extends RuntimeException {
        public TupleParserException(String arg) {
            super(arg);
        }
    }

    /**
     * Simple, recursive parser function.
     * 
     * @param input A String which contains all the tuples.
     * @param start Position where we start parsing.
     * @param output Where to store the result tuple.
     * @return An index of the character where we stopped parsing. 
     */
    public int parse(String input, int start, ArrayList output) {
        int idx = start;
        boolean finished = false;

        String part = "";

        while (idx < input.length() && !finished) {
            char ch = input.charAt(idx);
            switch (ch) {
                case '{':
                case '(':
                case '[':
                    ArrayList newTuple = new ArrayList();
                    output.add(newTuple);
                    ++idx;
                    idx = parse(input, idx, newTuple);
                    break;

                case '}':
                case ')':
                case ']':
                    output.add(part);
                    finished = true;
                    break;

                case ',':
                    output.add(part);
                    part = "";
                    break;

                default:
                    part += ch;
            } // switch
            ++idx;
        } // while

        return idx;
    }

    public ArrayList parse(String input) {
        ArrayList ret = new ArrayList();
        parse(input, 0, ret);
        return ret;
    }

    public static void main(String[] args) {
        String s = "{(30,2884090,1410450570357,235),(30,2863348,1410451100148,285)}";

        TupleParser tp = new TupleParser();
        ArrayList tuple = null;
        try {
            tuple = tp.parse(s);
            System.out.println(tuple.toString());
            tuple = tp.parse("1, 2, 5, 4"); // does not work yet
            System.out.println(tuple.toString());
        } catch (Exception e) {
            System.out.println(e.toString());
            e.printStackTrace();
        }
    }    
}