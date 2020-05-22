public void doit(String[] args) throws IOException {
    ...
    PrintWriter out = ...;
    out.println(outputString);
    ...
}

public static void main(String[] args) throws IOException {
    new main().doit(args);
}