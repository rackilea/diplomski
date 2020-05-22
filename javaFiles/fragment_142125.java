import java.util.Random;

public class Main {
    public static void main(String[] args) {
        System.out.println(generateRandomString());
        System.out.println(generateRandomString());
    }


    public static String generateRandomString() {
        String alphabet = "0123456789";
        String result = "";
        Random random = new Random();
        // build a random string construct will 0-9 and each digital appear once
        for (int i = 0; i < 10; i++) {
            int index = random.nextInt(alphabet.length());
            if (i == 0) { // first cannot be 0
                index = random.nextInt(alphabet.length() - 1) + 1;
            }
            String c = alphabet.substring(index, index + 1);
            result += c;
            alphabet = alphabet.replace(c, "");
        }
        return random.nextInt(2) == 0 ? shuffle1(random, result) : shuffle2(random, result);
    }

    // One of the digits has to be in the String 2 times and one has to not be there at all.
    private static String shuffle1(Random random, String result) {
        int from = random.nextInt(10);
        int to = random.nextInt(9) + 1;
        while (from == to) {
            to = random.nextInt(9) + 1;
        }
        result = result.replace(result.substring(to, to + 1), result.substring(from, from + 1));
        return result;
    }

    // One digit has to be there 3 times, and 2 other digits can not be there at all
    private static String shuffle2(Random random, String result) {
        int from = random.nextInt(10);
        int to1 = random.nextInt(9) + 1;
        int to2 = random.nextInt(9) + 1;
        while (from == to1) {
            to1 = random.nextInt(9) + 1;
        }
        while (from == to2 || to2 == to1) {
            to2 = random.nextInt(9) + 1;
        }
        result = result.replace(result.substring(to1, to1 + 1), result.substring(from, from + 1));
        result = result.replace(result.substring(to2, to2 + 1), result.substring(from, from + 1));
        return result;
    }

}