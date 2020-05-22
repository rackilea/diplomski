public class BreakWhenNoYellow {

    public static void main(String[] args) {
        BufferedImage capture = null;
        Rectangle screenRegion = new Rectangle(70, 102, 200, 220);
        do {
            capture = new Robot().createScreenCapture(screenRegion);
        } while (containsColor(capture, Color.YELLOW));
    }

    private boolean containsColor(BufferedImage image, Color toFind) {
        for (int y = 0; y < image.getHeight(); y++) {
            for (int x = 0; x < image.getWidth(); x++) {
                if (toFind.equals(new Color(image.getRGB(x, y)))) {
                   return true;
                }
            }
        }
        return false;
    } 
}