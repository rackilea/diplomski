import java.util.Scanner;
public class MethodOverload {
public static void main(String [] args){
    Scanner input = new Scanner(System.in);
    System.out.println ("Enter the int or double number");
    double y = input.nextDouble();

    if(y % 1 == 0) {
        int x = (int) y;
        System.out.printf("Square of integer value %d is %d", x, square(x));
    }else{
        System.out.printf("Square of double value %f is %f", y, square(y));
    }

}

public static int square(int intValue){
    System.out.printf ("\nCalled square method with int argument: %d", intValue);

    return intValue*intValue;
}

public static double square (double doubleValue){
    System.out.printf ("\nCalled sqauer method with double argument: %f", doubleValue);
    return doubleValue*doubleValue;
}

}