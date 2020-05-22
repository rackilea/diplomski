import java.io.*;
import java.util.Arrays;

/**
 * @author Colin Hebert
 */
public class Serial {

    public static void main(String[] args)
            throws IOException, ClassNotFoundException {
        PipedOutputStream pos = new PipedOutputStream();
        PipedInputStream pis = new PipedInputStream(pos);

        String[][] strings = new String[][]{{"q","w","e"},{"a","s","d"},{"z",
                "x","c"}};

        serialize(strings, pos);

        String[][] strings2 = deserialize(pis);

        System.out.println(Arrays.deepEquals(strings, strings2));
    }

    public static String[][] deserialize(InputStream is)
            throws IOException, ClassNotFoundException {
        ObjectInputStream ois = new ObjectInputStream(is);
        return (String[][]) ois.readObject();
    }

    public static void serialize(String[][] array, OutputStream os)
            throws IOException {
        ObjectOutputStream oos = new ObjectOutputStream(os);

        oos.writeObject(array);
        oos.flush();
    }
}