public class RandUniqueFourDigits {
    public static void main(String[] args) {
        System.out.println(generateSecretNumber());
    }

    public static int generateSecretNumber() {
        Random rand = new Random();
        int w = 0, x = 0, y = 0, z = 0;

        // Generate each digit until they're all unique
        w = rand.nextInt(10);
        do x = rand.nextInt(10); while(x == w);
        do y = rand.nextInt(10); while(y == w || y == x);
        do z = rand.nextInt(10); while(z == w || z == x || z == y);

        // Combine them into one integer and return
        return w * 1000 + x * 100 + y * 10 + z;
    }
}