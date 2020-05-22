import java.io.*;                                                            

public class Test {                                                          
  public static void main(String[] args) throws Exception {                  
    String[] command = { "./myscript", "key", "ls -t | tail -n 1" };         
    Process process = Runtime.getRuntime().exec(command);                    
    BufferedReader reader = new BufferedReader(new InputStreamReader(        
        process.getInputStream()));                                          
    String s;                                                                
    while ((s = reader.readLine()) != null) {                                
      System.out.println("Script output: " + s);                             
    }                                                                        
  }                                                                          
}