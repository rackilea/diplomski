import java.util.Random;

public class Main {

    private static Random r = new Random();

    public static void main(String[] args) {
        final int iterations = 1000000;
        System.out.println("Testing percentage based random, " + iterations + " iterations");
        int onePercent = 0;
        int sixPercent = 0;
        int sevenPercent = 0;
        int thirtySixPercent = 0;
        int fiftyPercent = 0;
        // Those values add up to 100% overall
        for (int i = 0; i < iterations; i++) {
            int random = r.nextInt(100);
            int totalPercent = 0;
            if (random < totalPercent + 1) {
                onePercent++;
                continue;
            }
            totalPercent += 1;
            if (random < totalPercent + 6) {
                sixPercent++;
                continue;
            }
            totalPercent += 6;
            if (random < totalPercent + 7) {
                sevenPercent++;
                continue;
            }
            totalPercent += 7;
            if (random < totalPercent + 36) {
                thirtySixPercent++;
                continue;
            }
            totalPercent += 36;
            if (random < totalPercent + 50) {
                fiftyPercent++;
                continue;
            }
            totalPercent += 50;
            // That can't be right because if random > 50 then nothing at all happens
        }
        System.out.println("One percent happened about " + (onePercent / Float.valueOf(iterations)) * 100 + "% of the time");
        System.out.println("Six percent happened about " + (sixPercent / Float.valueOf(iterations)) * 100 + "% of the time");
        System.out.println("Seven percent happened about " + (sevenPercent / Float.valueOf(iterations)) * 100 + "% of the time");
        System.out.println("Thirty six percent happened about " + (thirtySixPercent / Float.valueOf(iterations)) * 100 + "% of the time");
        System.out.println("Fifty percent happened about " + (fiftyPercent / Float.valueOf(iterations)) * 100 + "% of the time");
    }
}