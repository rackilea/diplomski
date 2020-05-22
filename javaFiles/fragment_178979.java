import java.util.Scanner;
public class Main
{

 public static void main(String[] args)
 {
    Scanner input = new Scanner(System.in);
    int radius = 0;
    if(input.hasNextInt() ){
        radius = input.nextInt();
    }
    int length = 0;
    //Scanner input2 = new Scanner(System.in);
    if(input.hasNextInt() ){
        length = input.nextInt();
    }
    while ((radius > 1000) || (radius < 1))
    {
       // input = new Scanner(System.in);
        if(input.hasNextInt() ){
          radius = input.nextInt();
        }
    }

    while ((length > 1000) || (length < 1))
    {
        //input2 = new Scanner(System.in);
        if(input.hasNextInt() ){
           length = input.nextInt();
        }
    }

    double area = (radius * radius) * 3.14159;
    double volume = area * length;

    System.out.printf("%.1f\n", area);
    System.out.printf("%.1f\n", volume);
  }
}