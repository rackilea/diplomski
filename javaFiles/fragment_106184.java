public class StatementMaker {
    private static String encode(String binding) {
        return "?" + binding;
    }

    private static String encode(URI uri) {
        return "<" + uri.stringValue() + ">";
    }

    private static String encode(Literal literal) {
        return "\"" + literal.stringValue() + "\"" + literal.getDatatype();
    }

    public static Statement from(String b) {
        return new Statement(encode(b));
    }

    public static Statement from(URI b) {
        return new Statement(encode(b));
    }

    public static Statement from(Literal b) {
        return new Statement(encode(b));
    }

    public static class Statement {

        private StringBuilder buf;
        private Statement(String s) {
            buf = new StringBuilder(" ");
            buf.append(s);
        }

        public Statement with(String s) {
            buf.append(" ").append(encode(b));
            return this;
        }

        public Statement with(URI s) {
            buf.append(" ").append(encode(b));
            return this;
        }

        public Statement with(Literal s) {
            buf.append(" ").append(encode(b));
            return this;
        }

        public String toString() {
            return buf.toString() + ".\n";
        }

    }
}