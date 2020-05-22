import java.util.Random;

public class Main {
    private static Random random = new Random();
    private static final int MAX = 1023;
    private static final int MIN = 16;

    public static void main(String[] args) {
        Integer randInt = random.nextInt((MAX - MIN) + 1) + MIN;
        System.out.println("random binary is: " + Integer.toBinaryString(randInt));
    }
}