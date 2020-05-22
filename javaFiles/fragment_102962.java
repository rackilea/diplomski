import java.io.*;
import java.nio.charset.StandardCharsets;

class Demo {
  public static void main(String[] args) throws IOException {
    try (FileOutputStream fos = new FileOutputStream("output.txt");
         OutputStreamWriter osw = new OutputStreamWriter(fos, StandardCharsets.UTF_8);
         BufferedWriter writer = new BufferedWriter(osw)) {
      writer.write("ⵉⵎⴰⵣⵉⵖⵏ");
    }

    try (RandomAccessFile raf = new RandomAccessFile("output.txt", "r")) {
      System.out.println(raf.readLine());
    }
  }
}