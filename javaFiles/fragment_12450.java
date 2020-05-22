try {
    final Bootstrap b = new Bootstrap(new ScreenshotCapturer());
    b.beginCapture(new ScreenCaptureCallback() {
        @Override
        public void captureEnded(CapturedImage img) {
            Thread t = new Thread(new Runnable() {
                @Override
                public void run() {
                    b.beginCapture(new ScreenCaptureCallback() {
                        @Override
                        public void captureEnded(CapturedImage img) {
                            System.out.println("...");
                            JFrame frame = new JFrame();
                            frame.add(new JLabel(new ImageIcon(img.getBufferedImage())));
                            frame.pack();
                            frame.setVisible(true);
                            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                        }
                    });
                }
            });
            t.start();
        }
    });
    System.out.println("Hello");
} catch (AWTException exp) {
    exp.printStackTrace();
}