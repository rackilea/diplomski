final PrintStream origout = System.out;
final PrintStream fileout = new PrintStream(file);
System.setOut(new PrintStream(new OutputStream() {
    @Override
    public void write(int b) throws IOException {
        origout.write(b);
        fileout.write(b);
    }
}));