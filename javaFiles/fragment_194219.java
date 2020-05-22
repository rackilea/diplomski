import java.io.*;
class HexDump {
  public static void main(String[] args) throws IOException {
    try (InputStream in = new FileInputStream(args[0])) {
      int r;
      while((r = in.read()) != -1) {
        System.out.format("%02x ", 0xFF & r);
      }
      System.out.println();
    }
  }
}