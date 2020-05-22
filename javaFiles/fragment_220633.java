PrintStream myStream = new PrintStream(System.out) {
    @Override
    public void println(String x) {
        super.println(System.currentTimeMillis() + ": " + x);
    }
};
System.setOut(myStream);
System.out.println("Hello World!");