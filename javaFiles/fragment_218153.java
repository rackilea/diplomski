BlockingQueue<?> queue = new SynchrnousQueue<?>();
class StartPeriodicTask implements Runnable {
    public void run() {
        Robot robot = null;
        try {
            robot = new Robot();
        } catch (AWTException e1) {
            e1.printStackTrace();
        }
        Rectangle screenRect = new Rectangle(Toolkit.getDefaultToolkit()
                .getScreenSize());
        BufferedImage image = robot.createScreenCapture(screenRect);
        queue.offer(image); //1
}
public class ImageConsumer implements Runnable {
        @Override
        public void run() {
            while (true) {
                BufferedImage bufferedImage = queue.poll(); //2

                File imageFile = getFile();
                if (!imageFile.getParentFile().exists()) {
                    imageFile.getParentFile().mkdirs();
                }
                    try {
                        ImageIO.write(bufferedImage, extension, imageFile);
                        //Image saved
                    catch (IOException e) {
                        tracer.severe("IOException occurred. Image is not saved to file!");
                    }
            }