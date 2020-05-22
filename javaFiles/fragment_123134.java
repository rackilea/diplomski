package mypackage;
import java.io.*;
import org.apache.commons.io.output.*;

public class TeeWrapper {
  public static void main(String[] args) throws Exception {
    FileOutputStream logFile = new FileOutputStream("log.txt");
    try {
      System.setOut(new PrintStream(new TeeOutputStream(System.out, logFile)));
      MyProgram.main(args);
    } finally {
      logFile.close();
    }
  }
}