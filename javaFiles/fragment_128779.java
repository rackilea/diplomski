import java.io.*;

class Test {
     public static void main(String args[]) throws Exception {
           RandomAccessFile f = new RandomAccessFile("t", "rw");
           f.setLength(1024 * 1024 * 1024);
     }
}