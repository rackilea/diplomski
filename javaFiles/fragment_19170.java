import java.io.*;
import java.util.*;

public class B {
  public static void main(String[] args) throws Exception {
    String os = "abc";

    System.out.println("---- unicode, big-endian");
    for(byte b: os.getBytes("UTF-16BE")) {
      System.out.println(b);
    }

    ByteArrayOutputStream baos = new ByteArrayOutputStream();
    DataOutputStream dos = new DataOutputStream(baos);

    for(char c: os.toCharArray()) {
      dos.writeChar(c);
    }

    byte[] ba = baos.toByteArray();

    System.out.println("---- ba");
    for(byte b: ba) {
      System.out.println(b);
    }

    ByteArrayInputStream bais = new ByteArrayInputStream(ba);
    DataInputStream dis = new DataInputStream(bais);

    System.out.println("---- dis");
    String s = dis.readLine();
    System.out.println(s);
    System.out.println("String length is " + s.length() 
      + ", but you would expect " + os.length() 
      + ", as that is what you see printed...");
  }
}