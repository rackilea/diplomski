public class Test {

      static {
        try {
            System.load("C:/PATH_TO/jmvfw.dll");
            System.out.println(String.format("%s has been successfully loaded","jmvfw"));
        } catch (UnsatisfiedLinkError e) {
          System.err.println("Native code library jmvfw  failed to load." , e);
          System.exit(1);
        }
      }
      //check if the lib is in java.library.path
      public static void main(String argv[]) {
        String libs = System.getProperty("java.library.path");
        for (String lib : libs.split(";")) 
            System.out.println(lib);

      }
    }