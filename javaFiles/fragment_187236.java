private static File directory;
@BeforeClass 
public static void setup() {
      directory = new File("/path/to/file");
      if(!directory.exists()){
          directory.mkdir();
      }
}

@AfterClass 
public static void teardown() {
      if(directory.exists()){
          FileUtils.deleteDirectory(directory); //apache-commons-io
      }
}