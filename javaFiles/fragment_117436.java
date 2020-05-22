import java.util.Scanner;

public class BiggerValue {
  public static void main (String [] args) {
   Scanner sc = new Scanner(System.in);
   int bigger = 0; //you need to initialise this
   int[] n = new int[10];
   System.out.print("Please enter " + n.length + " values:");
   for(int i = 0; i < n.length; i++) {
      n[i] = sc.nextInt(); 
    System.out.println(n[i]);
    if(bigger < n[i]) { //you should compare it with bigger, not n.
        bigger = n[i]; //there is nothing called num[i], it is n[i]
       }
     } 
      System.out.println("The highest number is " + bigger);
   }
}