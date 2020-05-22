public class Color {
    private static Random random = new Random();
    int colorValue = random.nextInt(3) + 1; // nextInt excludes 3 and includes 0

    @Override
    public String toString() {
        if (colorValue == 1) {
            return "Red";
        } else if (colorValue == 2) {
            return "Blue";
        } else if (colorValue == 3) {
            return "Yellow";
        }
        return "Unknown";
    }

    public static void main(String[] args) {
        Color color = new Color();
        System.out.println("The Color Generated was: " + color);
    }
}