import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectStreamException;
import java.io.Serializable;

public class AppState implements Serializable
{
    private static AppState s_instance = null;

    public static synchronized AppState getInstance() {
        if (s_instance == null) {
            s_instance = new AppState();
        }
        return s_instance;
    }

    private AppState() {
        // initialize
    }

    private void readObject(ObjectInputStream ois) throws IOException, ClassNotFoundException {
        ois.defaultReadObject();
        synchronized (AppState.class) {
            if (s_instance == null) {
                // re-initialize if needed

                s_instance = this; // only if everything succeeds
            }
        }
    }

    // this function must not be called other than by the deserialization runtime
    private Object readResolve() throws ObjectStreamException {
        assert(s_instance != null);
        return s_instance;
    }

    public static void main(String[] args) throws Throwable {
        assert(getInstance() == getInstance());

            java.io.ByteArrayOutputStream baos = new java.io.ByteArrayOutputStream();
            java.io.ObjectOutputStream oos = new java.io.ObjectOutputStream(baos);
            oos.writeObject(getInstance());
            oos.close();

            java.io.InputStream is = new java.io.ByteArrayInputStream(baos.toByteArray());
            ObjectInputStream ois = new ObjectInputStream(is);
            AppState s = (AppState)ois.readObject();
            assert(s == getInstance());
    }
}