import java.util.Random;

public class Example {
    public static void main(String[] args) {
        Random r = new Random();
        double d1 = r.nextDouble();
        double d2 = r.nextDouble();
        double d3 = d1 + d2;
        System.out.println(d3);
    }
}