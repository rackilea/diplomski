import java.util.Random;

public class Test {
    public static void main(String[] args) {
        Random rand = new Random();
        int x = 0;
        int rock = 0;
        int paper = 0;
        int scissors = 0;

        for (int i = 0; i < 100; i++) {
            x = rand.nextInt(3);
            if (x == 1) {
                rock += 1;
            } else if (x == 2) {
                paper += 1;
            } else {
                scissors += 1;
            }

        }

        System.out.println("Rock = " + rock + "\nPaper = " + paper + "\nScissors = " + scissors);
    }
}