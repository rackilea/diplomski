import java.io.*;

public class Client {

  public static void main(String[] args) throws IOException {
    // write string
    ObjectOutputStream out = new ObjectOutputStream(
      new BufferedOutputStream(
        new FileOutputStream("test-string.data")));
    try {
      out.writeObject("Hello");
    } finally {
      out.close();
    }
    // write byte arrays
    out = new ObjectOutputStream(
      new BufferedOutputStream(
        new FileOutputStream("test-byteArrays.data")));
    try {
      out.writeObject(new byte[] { 'H', 'e', 'l', 'l', 'o' });
      out.writeObject(new byte[] { 'W', 'o', 'r', 'l', 'd' });
    } finally {
      out.close();
    }
  }

}