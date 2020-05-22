public final static String PROJECT_DIR;

static {
     try {
       Map<String, String> env = System.getenv();

       if (!env.contains("HOME")) {
           throw new AssertionError("HOME not set as environment variable");
       }

       PROJECT_DIR = env.get("HOME") + "/Projects/MyTestProject";
     } catch (SecurityException e) {
       throw new AssertionError("Security policy doesn't allow access to system environment", e);
     }
 }