jcomeau@intrepid:/tmp$ cat /tmp/test.java; javac test.java; java test
import java.net.*;
import java.io.*;
public class test {
 public static void main(String args[]) throws Exception {
  String line;
  Process process = Runtime.getRuntime().exec("ls");
  BufferedReader process_out = new BufferedReader(
   new InputStreamReader(process.getInputStream()));
  while ((line = process_out.readLine()) != null)
   System.out.println(line);
  process.waitFor();
 }
}
bin
hash.class
hash.java
hsperfdata_jcomeau
profile
test.class
test.java
tmpe66f4e
tmplvOd2n
tmpn8FI2Q
tmpoYaciK
tmpx27knK
vmlinux
繁體中文.txt