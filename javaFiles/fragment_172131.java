import java.io.*;
import java.util.*;

public class Server {

  public static void main(String[] args) throws IOException, ClassNotFoundException {
    // write string
    ObjectInputStream in = new ObjectInputStream(
      new BufferedInputStream(
        new FileInputStream("test-string.data")));
    try {
      Object o = null;
      while ((o = in.readObject()) != null) {
        System.out.printf("Class: %s, toString: %s\n", o.getClass(), o.toString());
      }
    } catch (EOFException e) {
      // finished
    } finally {
      in.close();
    }
    // write byte arrays
    in = new ObjectInputStream(
      new BufferedInputStream(
        new FileInputStream("test-byteArrays.data")));
    try {
      Object o = null;
      while ((o = in.readObject()) != null) {
        System.out.printf("Class: %s, toString: %s\n", o.getClass(), o.toString());
      }
    } catch (EOFException e) {
      // finished
    } finally {
      in.close();
    }
  }

}