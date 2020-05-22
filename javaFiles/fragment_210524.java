package example;
 
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.util.zip.GZIPInputStream;
 
public class GZipUtil {
 
 /**
  * Checks if an input stream is gzipped.
  * 
  * @param in
  * @return
  */
 public static boolean isGZipped(InputStream in) {
  if (!in.markSupported()) {
   in = new BufferedInputStream(in);
  }
  in.mark(2);
  int magic = 0;
  try {
   magic = in.read() & 0xff | ((in.read() << 8) & 0xff00);
   in.reset();
  } catch (IOException e) {
   e.printStackTrace(System.err);
   return false;
  }
  return magic == GZIPInputStream.GZIP_MAGIC;
 }
 
 /**
  * Checks if a file is gzipped.
  * 
  * @param f
  * @return
  */
 public static boolean isGZipped(File f) {
  int magic = 0;
  try {
   RandomAccessFile raf = new RandomAccessFile(f, "r");
   magic = raf.read() & 0xff | ((raf.read() << 8) & 0xff00);
   raf.close();
  } catch (Throwable e) {
   e.printStackTrace(System.err);
  }
  return magic == GZIPInputStream.GZIP_MAGIC;
 }
 
 public static void main(String[] args) throws FileNotFoundException {
  File gzf = new File("/tmp/1.gz");
 
  // Check if a file is gzipped.
  System.out.println(isGZipped(gzf));
 
  // Check if a input stream is gzipped.
  System.out.println(isGZipped(new FileInputStream(gzf)));
 }
}