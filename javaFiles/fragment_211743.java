PrintStream out = System.out;
System.setOut(new PrintStream(new OutputStream() {
    @Override public void write(int b) throws IOException {}
}));
try {
    <library call>
} finally {
    System.setOut(out);
}