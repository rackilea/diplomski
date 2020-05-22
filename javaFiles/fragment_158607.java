import java.util.Scanner;  
public class fibs  
{  
 public static void main(String[] args)  
 {  
  Scanner keyboard = new Scanner(System.in); // readying keyboard for input  
  int f1, f2, n, fib = 0;  
  System.out.println("Please enter a vaule for F(1):");  
  f1 = keyboard.nextInt();  
  System.out.println("Please enter a vaule for F(2):");  
  f2 = keyboard.nextInt();  
  System.out.println("Please enter a vaule for n :");  
  n = keyboard.nextInt();  

  if ((f1<0)||(f2<0)||(f1>1000)||(f2>1000)||(n<1))  
  {  
   System.out.println("Please try again");  
   return;  
  }  
  else  
  {  
   for (int i=2; i<n; i++)  
   {  
    fib=f1+f2;  
    f1=f2;  
    f2=fib;        
   }
   System.out.println( fib );  
  }  
 }  
}