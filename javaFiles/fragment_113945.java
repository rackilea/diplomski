public class Play {

    public static void main(String[] arg) throws IOException {

        int SENTINEL = 10;
        int input = 0;
        List<Integer> numberList = new ArrayList<>();

        System.setIn(new UnClosableDecorator(System.in));

        do {
            Scanner in = new Scanner(System.in);
            System.out.println("?");
            input = in.nextInt();
            System.out.println("[" + input + "]");
            in.close();
            if(input != SENTINEL) {
                numberList.add(input);
            }

        } while(input != SENTINEL);
        System.out.println("done");
    }
}


class UnClosableDecorator extends InputStream {

    private final InputStream inputStream;

    public UnClosableDecorator(InputStream inputStream) {
        this.inputStream = inputStream;
    }

    @Override
    public int read() throws IOException {
        return inputStream.read();
    }

    @Override
    public int read(byte[] b) throws IOException {
        return inputStream.read(b);
    }

    @Override
    public int read(byte[] b, int off, int len) throws IOException {
        return inputStream.read(b, off, len);
    }

    @Override
    public long skip(long n) throws IOException {
        return inputStream.skip(n);
    }

    @Override
    public int available() throws IOException {
        return inputStream.available();
    }

    @Override
    public synchronized void mark(int readlimit) {
        inputStream.mark(readlimit);
    }

    @Override
    public synchronized void reset() throws IOException {
        inputStream.reset();
    }

    @Override
    public boolean markSupported() {
        return inputStream.markSupported();
    }

    @Override
    public void close() throws IOException {
        //do nothing
    }
}