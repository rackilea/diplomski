import java.io.*;

public class Test {
  public static void main(String[] args) {
  try{            
    String text = "this is just a test ";
    FileWriter fw = new FileWriter("/home/myhome/tmp/out 21.txt");
    fw.write(text);
    fw.close();
  }catch(IOException e ){
  System.out.println("Something went wrong ");
  }  
}