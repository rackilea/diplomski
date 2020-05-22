public class RandUniqueFourDigits {
    public static void main(String[] args) {
        System.out.println("Random number is: " + generateSecretNumber());
    }

    public static int generateSecretNumber() {
        Random rand = new Random();
        int w = 0, x = 0, y = 0, z = 0;

        // Generate each digit until they're all unique
        while(w == x || w == y || w == z || x == y || x == z || y == z) {
            w = rand.nextInt(10);
            x = rand.nextInt(10);
            y = rand.nextInt(10);
            z = rand.nextInt(10);
        }

        // Generate each digit until they're all unique
        w = rand.nextInt(10);
        do x = rand.nextInt(10); while(x == w)

        // Combine them into one integer and return
        return w * 1000 + x * 100 + y * 10 + z;
    }
}