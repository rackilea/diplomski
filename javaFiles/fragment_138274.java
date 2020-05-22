package egPriv;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.security.AccessController;
import java.security.PrivilegedActionException;
import java.security.PrivilegedExceptionAction;

public class PrivCat {
    /** Cat a file with no privileges */
    public void cat(String file) throws IOException {
        cat(new FileReader(file));
    }

    private void cat(Reader r) throws IOException {
        int c;
        while( (c = r.read()) != -1 ) {
            System.out.print((char) c);
        }
        r.close();
    }

    /** Cat a file WITH privileges */
    public void catPriv(final String file) throws IOException {
        Reader r;
        try {
            r = AccessController.doPrivileged(new PrivilegedExceptionAction<Reader>() {
                public Reader run() throws IOException {
                    return new FileReader(file);
                }
            });
        } catch (PrivilegedActionException e) {
            throw (IOException) e.getCause();
        }
        cat(r);
    }
}