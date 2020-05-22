import java.lang.*;
import java.io.*;
import java.util.*;

public class Mkt {
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new FileReader("in.txt"));
    List<Byte> bytesList = new ArrayList<Byte>();

    // Read line by line
    for(String line = br.readLine(); line != null; line = br.readLine()) {
      // 4 byte representations per line
      for(int i = 0; i < 4; i++) {
        // Get each of the 4 bytes (i.e. 8 characters representing the byte)
        String part = line.substring(i * 8, (i + 1) * 8);
        // Parse that into the binary representation
        // Integer.parseInt is used as byte in Java is signed (-128 to 127)
        byte currByte = (byte)Integer.parseInt(part, 2);
        bytesList.add(currByte);
      }
    }

    Byte[] byteArray = bytesList.toArray(new Byte[]{});

    // Just print for test
    for(byte currByte: byteArray) {
      System.out.println(currByte);
    }
  }
}