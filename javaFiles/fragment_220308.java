public static final String startingPath;
 static {
    String path = null;
    try {
      path = new File(".").getCanonicalPath();
    } catch (IOException e) {
      // do whatever you have to do
    }
    startingPath = path;
 }