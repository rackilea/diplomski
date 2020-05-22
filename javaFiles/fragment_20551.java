public class ShapeManager {
    private static Random random = new Random();

    public static Shape getRandomShape() {
        switch (random.nextInt(2)) {
            case 0:
                return new Square(5);
            case 1:
                return new Circle(5);
        }

        return null;
    }
}