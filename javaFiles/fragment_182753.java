import java.io.FileNotFoundException;
 import java.io.FileWriter;
 import java.io.IOException;
 import java.io.PrintWriter;
  public class multicatch {
public static void main(String[] args) throws FileNotFoundException, IOException {

        Throwable t = new Exception("This is some kind of throwable exception");  
        PrintWriter ps=new PrintWriter(new FileWriter("F:\\fff.txt", true));
    ps.write(t.getMessage());

        ps.close();
  }      
 }