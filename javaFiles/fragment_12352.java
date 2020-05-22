public class IgnoreFirstLineBufferedWriter extends BufferedWriter {
    private int lineCouner = 0;
    // constructors - implement them yourself

    @Override
    public void write(String str) throws IOException {
        if (lineCounter > 0) {
            super.write(str);
        }
        lineCounter++;
    }
}