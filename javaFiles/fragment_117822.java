import java.util.*;

public class InputSum {
   public static void main(String[] args) {
      int data;
      Scanner input = new Scanner(System.in);
      System.out.println("Enter an interger (The input end if it is -1): ");
      data = input.nextInt();
      double y =data;
      // constructing a string for output
      StringBuilder sb=new StringBuilder();
      int sum = 0;
      while (data != -1){
         sum+= data;
         // adding each number to the output String
         sb.append(data + ",");
         System.out.println(
            "Enter an interger (The input end if it is -1): ");
         data = input.nextInt();
      }
      sb.deleteCharAt(sb.length()-1);
      // the output is not a number, its a String
      System.out.print(sb.toString());
      System.out.println();
      System.out.println("The sum:" + sum);
   }
}