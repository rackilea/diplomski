package redirecter;

import java.io.IOException;
import java.io.InputStream;

public class Redirecter {

    public static void main(String[] args) {
        final InputStream oldIn = System.in;
        InputStream hackedIn = new InputStream() {

            @Override
            public int read() throws IOException {
                int b = oldIn.read();
                System.out.write(b);
                return b;
            }

            @Override
            public int read(byte[] b, int off, int len) throws IOException {
                int res = oldIn.read(b, off, len);
                System.out.write(b, off, res);
                return res;
            }
        };
        System.setIn(hackedIn);

        test.Test.main(args);
    }
}