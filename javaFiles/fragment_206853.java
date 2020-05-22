public class StreamGobbler implements Runnable {
   private static String userdir;
   private String name;
   private LineIterator lineIterator;

   public StreamGobbler(String name, InputStream inStream) {
      this.name = name;
      BufferedReader bufReader = new BufferedReader(new InputStreamReader(
            inStream));
      lineIterator = IOUtils.lineIterator(bufReader);
   }

   @Override
   public void run() {
      try {
         while (lineIterator.hasNext()) {
            String line = lineIterator.nextLine();
            System.out.println(line);
            // ...
         }

      } finally {
         LineIterator.closeQuietly(lineIterator);
      }

   }

   public String getName() {
      return name;
   }
}