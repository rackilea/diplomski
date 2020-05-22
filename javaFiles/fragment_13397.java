public class PixelBot {

private final Robot bot;

private boolean running = true;

private int lastPixelValue = 0;

public static void main(String[] args) throws Exception {
    new PixelBot();
}

public PixelBot() throws AWTException {
    this.bot = new Robot();
    this.runInBackground();
}

private void checkPixel() {
    Rectangle areaOfInterest = getAreaOfInterest();
    BufferedImage image = bot.createScreenCapture(areaOfInterest);

    int clr = image.getRGB(0, 0);
    if (clr != lastPixelValue) {
        int red = (clr & 0x00ff0000) >> 16;
        int green = (clr & 0x0000ff00) >> 8;
        int blue = clr & 0x000000ff;
        System.out.println("\nPixel color changed to: Red: " + red + ", Green: " + green + ", Blue: " + blue);
        Toolkit.getDefaultToolkit().beep();
        lastPixelValue = clr;
    } else {
        System.out.print(".");
    }
}

private Rectangle getAreaOfInterest() {
    // screen size may change:
    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    // half of screen, minus 1 pixel to be captured:
    int centerPointX = (int) (screenSize.getWidth() / 2 - 1);
    int centerPointY = (int) (screenSize.getHeight() / 2 - 1);
    Point centerOfScreenMinusOnePixel = new Point(centerPointX, centerPointY);
    return new Rectangle(centerOfScreenMinusOnePixel, new Dimension(1, 1));
}

private void runInBackground() {
    new Thread(new Runnable() {

        @Override
        public void run() {
            while (running) {
                checkPixel();
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }).start();
}

public void stop() {
    this.running = false;
}
}