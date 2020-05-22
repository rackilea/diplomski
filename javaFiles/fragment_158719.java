public class Example {

      private OutputStream os;

      public Example(OutputStream os) {
          this.os = 0s;
      }

      protected void finalize() {
          try {
              os.close();
          } catch (IOException ex) {
              // ignore it
          }
     }
  }