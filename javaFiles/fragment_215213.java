package mod8;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * Java implementation of the Unix tail command
 * 
 * @param args[0] File name
 * @param args[1] Update time (seconds). Optional. Default value is 1 second
 * 
 * @author Luigi Viggiano (original author) http://it.newinstance.it/2005/11/19/listening-changes-on-a-text-file-unix-tail-implementation-with-java/
 * @author Alessandro Melandri (modified by)
 * @author Jason Millerm hack-r.com (modified by)
 * */
public class Tail {

  static long sleepTime = 1000;

  public static String JavaTail(String args) throws IOException {
    String out = "";

      BufferedReader input = new BufferedReader(new FileReader(args));
      String currentLine = null;

      while (true) {

    if ((currentLine = input.readLine()) != null) {
      out += currentLine;
      continue;
    }
    input.close();
    return(out);

  /* try {
      Thread.sleep(sleepTime);
    } catch (InterruptedException e) {
      Thread.currentThread().interrupt();
      break;
    } */


      //
      //return(out);

    } 
  }
}