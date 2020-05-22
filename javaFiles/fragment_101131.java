static class Console extends OutputStream {
    private PrintStream out;

    public Console() {
        out = System.out;
    }

    @Override
    public void write(int i) throws IOException {
        out.write(i);
    }
}

public static void main(String[] args) throws Exception {
    Console console = new Console();
    PrintStream ps = new PrintStream(console, true);
    System.setOut(ps);
    System.setErr(ps);
    ps.println("Привет, мир!");
}