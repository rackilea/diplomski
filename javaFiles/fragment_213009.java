import java.util.Scanner;
import java.util.*;
public class Test3{
     public static void main(String args[]) {
     Scanner in=new Scanner(System.in);
     StringBuilder sb = new StringBuilder();
     String numStr; 
     System.out.print("Enter A Number: ");
     int limit=in.nextInt();
        for (int i=0;i<limit;i++){
           numStr=in.next();
           sb.append(numStr);
          }
        System.out.println(sb.reverse().toString());
  }
}