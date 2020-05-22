import java.nio.file.*;
 public class MimeTypes {
       public static void main(String[] args) {
          Path path;
          try {
             path = Paths.get("/etc");  
             System.out.println( path + " : " + Files.probeContentType(path) );

             path = Paths.get("/dev/null");  
             System.out.println( path + " : " + Files.probeContentType(path) );

             path = Paths.get("/var/log/syslog.2.gz");  
             System.out.println( path + " : " + Files.probeContentType(path) );

             path = Paths.get("/var/run/rpcbind.sock");  
             System.out.println( path + " : " + Files.probeContentType(path) );

             path = Paths.get("abc.mp4");  
             System.out.println( path + " : " + Files.probeContentType(path) );

             path = Paths.get("MimeTypes.java");  
             System.out.println( path + " : " + Files.probeContentType(path) );
          } catch (Exception x) {
          }
       }
    }