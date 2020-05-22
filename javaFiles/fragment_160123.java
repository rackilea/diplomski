import java.util.*;
import java.io.*;
import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;

public class Main {
 public static void main(String[] args) throws Exception {
  // Your code here!
  String response = "";
  DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");

  //STEP 1
  InputStream in = new ByteArrayInputStream("MYSTREAMASDasdasdSJKDFJASLKFJKSDLFJLKSADJFKSJDKAFJKSDJFLKSDJLKFJLKSDFJLKSDJLKLAKSDJLJKFSDKJADFSLJKLKJSDALJKALJKS adkaslkdajslkdjkaslkdjlaks\nasdasdasdasdasdasdasdasdasdasdasdasdasdas".getBytes());

  System.out.println("FIRST OPTION");
  long beginTime = System.nanoTime();
  //System.out.println("begin -" + beginTime);
  for (int i = 0; i < 500000; i++) {
   ByteArrayOutputStream baos = new ByteArrayOutputStream();
   byte[] buffer = new byte[4096];
   int length = 0;
   while ((length = in .read(buffer)) != -1) {
    baos.write(buffer, 0, length);
   }
   response = new String(baos.toByteArray());
  }
  long endTime = System.nanoTime();
  System.out.println(endTime - beginTime);

  //STEP 2
  System.out.println("SECOND OPTION");
  beginTime = System.nanoTime();
  for (int i = 0; i < 500000; i++) {
   response = "";
   BufferedReader br = new BufferedReader(new InputStreamReader( in ));
   String output;
   while ((output = br.readLine()) != null) {
    response = output;
   }
  }
  endTime = System.nanoTime();
  System.out.println(endTime - beginTime);

  System.out.println("THIRD OPTION");
  beginTime = System.nanoTime();
  for (int i = 0; i < 500000; i++) {
   StringBuilder sb = new StringBuilder();
   for (int c;
    (c = in .read()) >= 0;)
    sb.append((char) c);
   response = sb.toString();
  }
  endTime = System.nanoTime();
  System.out.println(endTime - beginTime);
 }
}