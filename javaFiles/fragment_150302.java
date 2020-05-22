import java.io.*;

public class Test {
    public static void main(String[] args) throws Exception {
        try (ByteArrayOutputStream output = new ByteArrayOutputStream()) {
            try (ObjectOutputStream oos = new ObjectOutputStream(output)) {
                oos.writeObject(new byte[5]);
            }
            byte[] data = output.toByteArray();
            System.out.println(data.length);
        }
    }
}