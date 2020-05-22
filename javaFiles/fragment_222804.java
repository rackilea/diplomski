import java.util.Scanner;
public class Main{
  public static void main(String args[])
  {
    int age=0;
    String name="";
    Scanner scan=new Scanner(System.in);

    System.out.println("Please Enter value of your age : ");
    age=scan.nextInt();

    scan.nextLine(); // This line you have to add (It consumes the \n character)


    System.out.println("Please Enter value of your name : ");
    name=scan.nextLine();

    System.out.println("Age : "+age+", Name : "+name);
  }
}