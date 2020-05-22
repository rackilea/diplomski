import java.io.*;

public class BinaryStream {
    public static void binaryStream(String file1, String file2) throws Exception
    {
      File sourceFile = new File(file1);
      try(
        FileInputStream inputStream = new FileInputStream(sourceFile); 
        FileOutputStream outputStream = new FileOutputStream(new File(file2))
      ) {
        long lenOfFile = sourceFile.length();

        long currentBytesWritten = 0;
        int data;
        while ((data = inputStream.read()) != -1) {
          outputStream.write(data);
          currentBytesWritten += 1;
          System.out.printf("%2.2f%%%n",
              100*((double)currentBytesWritten)/((double)lenOfFile));
        }
      }
   }

   public static void main(String args[]) throws Exception {
      binaryStream("Untitled.png", "Untitled-copied.png");
   }
}