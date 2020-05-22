public class SharedFile
 {
      private final File path;
      private final Object lock = new Object();

      public SharedFile(File path) {
         this.path = path;
      }

      public void process(.....) throws IOException {
         synchronized(lock) {
            try(InputStream = new FileInputStream(path)) {
               ....
            }
         }
      }
 }