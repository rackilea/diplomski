import java.io.FileWriter;
  import java.io.IOException;  
  public class TestClass {
      public static String newLine = System.getProperty("line.separator");
      public static void main(String[] a) {
        FileWriter writer;
        try {
          writer = new FileWriter("test.txt");
          for(int i=0;i<3;i++){
            writer.write(row+i+newLine);
          }
          writer.close();
        } catch (IOException e) {
          e.printStackTrace();
        }

      }
    }