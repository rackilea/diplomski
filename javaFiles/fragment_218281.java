import java.util.Scanner;

public class Circle{

    private double radius;

    public Circle(double r){

        radius = r;
    }

    public double diameter(){

        double d = radius * 2;
        return d;
    }

    public static void main(String args[]){

        Scanner dd = new Scanner(System.in);

        System.out.println("Whats is the radius?");
        double r = dd.nextDouble();
        Circle cir1 = new Circle(r);
        System.out.println(cir1.diameter())
    }
}