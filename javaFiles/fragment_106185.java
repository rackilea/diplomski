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

    public String and(String s) {
        buf.append(" ").append(encode(b));
        return buf.toString() + ".\n";
    }

    public String and(URI s) {
        buf.append(" ").append(encode(b));
        return buf.toString() + ".\n";
    }

    public String and(Literal s) {
        buf.append(" ").append(encode(b));
        return buf.toString() + ".\n";
    }


    public String toString() {
        return buf.toString() + ".\n";
    }

}