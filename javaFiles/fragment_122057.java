import java.io.*;                                                                   
import java.util.*;                                                                 

class Test {                                                                        
  public static void main(String args[]) {                                          
    Scanner scanner = new Scanner(System.in);                                       
    boolean done = false;                                                           
    double d1 = 0;                                                                  
    do {                                                                            
      System.out.print("Please enter Side 1:\t");                                   
      String next = scanner.next();                                                 
      try {                                                                         
        d1 = Double.parseDouble(next);                                              
        done = true;                                                                
      } catch (Exception e) {                                                       
        System.out.print("Side should be a number!\t");                              
      }                                                                             
    }                                                                               
    while(!done);   
    System.out.println("Number obtained: " + d1);                                                                
  }                                                                                 
}