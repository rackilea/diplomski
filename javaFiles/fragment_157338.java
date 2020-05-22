public static void takeScreenshot() {
        try {
            BufferedImage image = new Robot().createScreenCapture(new Rectangle(490,490,30,30));
/* this two first parameters are the initial X and Y coordinates. And the last ones are the increment of each axis*/
            ImageIO.write(image, "png", new File("C:\\Example\\Folder\\capture.png"));

        } catch (IOException e) {
            e.printStackTrace();
        } catch (HeadlessException e) {
            e.printStackTrace();
        } catch (AWTException e) {
            e.printStackTrace();
        }
    }