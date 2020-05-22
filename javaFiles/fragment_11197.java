public class OurMain {

    public static void main(String[] args) {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

        int screenWidth = screenSize.width;
        int screenHeight = screenSize.height;

        Random rand = new Random();

        MyFrame frame = new MyFrame();

        for (int g = 0; g < 50; g++) {
            int frameWidth = rand.nextInt(screenSize.width);
            int frameHeight = rand.nextInt(screenSize.height);

            int frameLocationX = rand.nextInt(screenWidth - frameWidth);
            int frameLocationY = rand.nextInt(screenHeight - frameHeight);

            frame.setSize(frameWidth, frameHeight);
            frame.setLocation(frameLocationX, frameLocationY);
            frame.setVisible(true);

            try {
                Thread.sleep(1000); // Waits 1000 miliseconds = 1 second
            } catch (InterruptedException e) { }

            frame.setVisible(false);

            try {
                Thread.sleep(1000); // Waits 1000 miliseconds = 1 second
            } catch (InterruptedException e) { }
        }
    }
}