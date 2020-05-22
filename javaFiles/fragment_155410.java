in = new Scanner(new DirtFilterInputStream(skt.getInputStream()), "Windows-1252");

public class DirtFilterInputStream extends InputStream {

    private InputStream in;

    public DirtFilterInputStream(InputStream in) {
        this.in = in;
    }

    @Override
    public int read() throws IOException {
        int ch = in.read();
        if (ch != -1) {
            if (ch == 0) {
                ch = read();
            }
        }
        return ch;
    }

}