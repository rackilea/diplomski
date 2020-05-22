import java.io.*;                                                            

public class Test {                                                          
  public static void main(String[] args) throws Exception {                  
    String[] command = { "./flows.sh", "suspend" };         
    Process process = Runtime.getRuntime().exec(command);                    
    BufferedReader reader = new BufferedReader(new InputStreamReader(    
        process.getInputStream()));                                          
    String s;                                                                
    while ((s = reader.readLine()) != null) {                                
      System.out.println("Script output: " + s); // Replace this line with the code to print the result to file                     
    }                                                                        
  }                                                                          
}