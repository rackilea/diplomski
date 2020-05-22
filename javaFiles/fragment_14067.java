import java.io.*;

public class BinaryStream {
  public static void binaryStream(String file1, String file2) throws Exception {
    File sourceFile = new File(file1);
    try(
      FileInputStream inputStream = new FileInputStream(sourceFile);
      FileOutputStream outputStream = new FileOutputStream(new File(file2))
    ) {
      long lenOfFile = sourceFile.length();
      long bytesWritten = 0;
      int amountOfBytesRead;
      byte[] bytes = new byte[256];

      while ((amountOfBytesRead = inputStream.read(bytes)) != -1) {
        outputStream.write(bytes, 0, amountOfBytesRead);
        bytesWritten += amountOfBytesRead;
        System.out.printf("%2.2f%%%n",
            100*((double)bytesWritten)/((double)lenOfFile));
      }
    }
  }

  public static void main(String args[]) throws Exception {
    binaryStream("Untitled.png", "Untitled-copied.png");
  }
}