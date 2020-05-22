import java.util.Scanner;
public class Main
{
 public static void main(String[] args) {
     String heroname;
     Scanner input = new Scanner(System.in);
  System.out.println("Hello World");
  String name;
  boolean isName = false;
  while(isName==false){
      System.out.println("Name: ");
      name = (input.nextLine());
      if(name.length()>0){
          heroname = name;
          isName = true;
      }else{
             System.out.println("Try Again");

      }
  }
 }
 
}