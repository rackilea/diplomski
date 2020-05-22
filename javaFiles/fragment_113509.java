import java.util.Scanner;
class MethodLoop{
public static void main(String [] args){
     Scanner s = new Scanner (System.in);
     System.out.println("Enter a number: ");
     int x= s.nextInt();
     print(x);
 }
 public static void print (int x){
     for(int y=1;y<x;y++){
         System.out.println(y);
     }
 }}