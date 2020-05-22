import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class myClass implements Serializable {
    private static final long serialVersionUID = /* some UID */;
    /* ...
     * class properties
     */

    myClass(/* args */) {
        // Initialize
    }

    /* ...
     * class methods
     */

    private void writeObject(ObjectOutputStream o) throws IOException {
        // Write out to the stream
    }

    private void readObject(ObjectInputStream o) throws IOException,
            ClassNotFoundException {
        // Read in and validate from the stream
    }
}