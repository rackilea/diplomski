public SingletonConfigFile {
   private static String filename = "config.xml";
   private File file;
   private static SingletonConfigFile instance;

   private SingletonConfigFile() {
       if (instance != null) {
           throw new Error();
       }
       file = new File(filename);
   }

   public synchronized SingletonConfigFile getInstance() {
      if (instance == null) {
          instance = new SignletonConfigFile();
      }
      return instance
   }

   public String read() {
       // delegate to the underlying java.io.File
   }
}