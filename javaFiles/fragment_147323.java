public class Test {

    enum Direction {
        Right,
        Up,
        Left,
        Down
    }

    public static void main(String... args) throws IOException {

        BufferedImage image = new BufferedImage(100, 100, BufferedImage.TYPE_INT_ARGB);

        int rgb = Color.BLACK.getRGB();

        Point p = new Point(50, 50);
        Direction d = Direction.Right;
        int currentSegmentLength = 1;


        for (int i = 0; i < 100; i += 2) {

            paintSegment(image, rgb, p, d, currentSegmentLength);
            d = nextSegmentDirection(d);

            paintSegment(image, rgb, p, d, currentSegmentLength);
            d = nextSegmentDirection(d);

            currentSegmentLength++;
        }


        ImageIO.write(image, "png", new File("test.png"));
    }

    private static void paintSegment(BufferedImage image, int rgb, Point p,
            Direction d, int currentSegmentLength) {

        for (int s = 0; s < currentSegmentLength; s++) {
            image.setRGB(p.x, p.y, rgb);

            switch (d) {
            case Right: p.x++; break;
            case Up:    p.y--; break;
            case Left:  p.x--; break;
            case Down:  p.y++; break;
            }
        }
    }

    private static Direction nextSegmentDirection(Direction d) {
        switch (d) {
        case Right: return Direction.Up;
        case Up:    return Direction.Left;
        case Left:  return Direction.Down;
        case Down:  return Direction.Right;

        default: throw new RuntimeException("never here");
        }
    }
}