public class MyPrintStream extends PrintStream {

    public MyPrintStream(OutputStream out) {
        super(out);
    }

    @Override
    public void println(String string) {
        Date date = new Date();
        super.println("[" + date.toString() + "] " + string);
    }
}